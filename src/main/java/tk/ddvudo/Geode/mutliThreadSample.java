package tk.ddvudo.Geode;

import com.alibaba.fastjson.JSON;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;
import tk.ddvudo.Mybatis.JavaBeans.Enterprise;
import tk.ddvudo.Mybatis.JavaBeans.EnterpriseExample;
import tk.ddvudo.Mybatis.UseAnnotation.EnterpriseDao;
import tk.ddvudo.Redis.Mysql2RedisSample;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class mutliThreadSample {
    private static String regionName = "Enterprise";

    public static void main(String... args) throws IOException {
        clear();
        singleThread();
    }

    private static void clear() {
        ClientCache cache = new ClientCacheFactory().addPoolLocator("localhost", 10334).set("log-level", "ERROR").create();
        ClientRegionFactory rf = cache.createClientRegionFactory(ClientRegionShortcut.PROXY);
        Region region = rf.create(regionName);
        region.clear();
        cache.close();
    }

    private static void singleThread() throws IOException {
        Logger logger = Logger.getRootLogger();
        ExecutorService pool = Executors.newCachedThreadPool();
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        ClientCache cache = null;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            EnterpriseDao enterMapper = session.getMapper(EnterpriseDao.class);
            EnterpriseExample enterpriseExample = new EnterpriseExample();
            enterpriseExample.setOrderByClause("id desc");
            long count = enterMapper.countByExample(enterpriseExample);
            count = 100000;
            int pageSize = 1000;
            cache = new ClientCacheFactory().addPoolLocator("localhost", 10334).set("log-level", "ERROR").create();
            ClientRegionFactory rf = cache.createClientRegionFactory(ClientRegionShortcut.PROXY);
            Region region = rf.create(regionName);
            for (int i = 0; i * pageSize < count; i++) {
                long offset = (i * pageSize);
                pool.submit(() -> {
                    try (SqlSession session_tmp = sqlSessionFactory.openSession()) {
                        EnterpriseDao enterMapper_tmp = session_tmp.getMapper(EnterpriseDao.class);
                        EnterpriseExample enterpriseExample_tmp = new EnterpriseExample();
                        enterpriseExample_tmp.setOrderByClause("id desc");
                        enterpriseExample_tmp.setOffset(offset);
                        enterpriseExample_tmp.setLimit(pageSize);
                        List<Enterprise> res = enterMapper_tmp.selectByExample(enterpriseExample_tmp);
                        for (Enterprise enterprise : res) {
                            logger.info("已处理id=" + enterprise.getId() + ",线程" + enterprise.toString());
                            region.put(enterprise.getKey(), enterprise);
                        }
                    }
                });
            }
        } finally {
            pool.shutdown();
            cache.close();
        }
    }
}
