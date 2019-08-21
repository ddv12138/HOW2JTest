package tk.ddvudo.Geode;

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
import tk.ddvudo.Mybatis.JavaBeans.Enterprise;
import tk.ddvudo.Mybatis.JavaBeans.EnterpriseExample;
import tk.ddvudo.Mybatis.UseAnnotation.EnterpriseDao;

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
        ExecutorService pool = Executors.newFixedThreadPool(4);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        ClientCache cache = null;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            EnterpriseDao enterMapper = session.getMapper(EnterpriseDao.class);
            EnterpriseExample enterpriseExample = new EnterpriseExample();
            enterpriseExample.setOrderByClause("id desc");
            long count = enterMapper.countByExample(enterpriseExample);
            int pageSize = 1000;
            cache = new ClientCacheFactory().addPoolLocator("localhost", 10334).set("log-level", "ERROR").create();
            ClientRegionFactory rf = cache.createClientRegionFactory(ClientRegionShortcut.PROXY);
            Region region = rf.create(regionName);
            for (int i = 0; i * pageSize < count; i++) {
                long offset = (i * pageSize);
                enterpriseExample.setOffset(offset);
                enterpriseExample.setLimit(pageSize);
                List<Enterprise> res = enterMapper.selectByExample(enterpriseExample);
                pool.submit(() -> {
                    for (Enterprise enterprise : res) {
                        logger.info("已处理id=" + enterprise.getId() + ",线程" + enterprise.toString());
                        region.put(enterprise.getKey(), enterprise);
                    }
                });
            }
        } finally {
            pool.shutdown();
            cache.close();
        }
    }
}
