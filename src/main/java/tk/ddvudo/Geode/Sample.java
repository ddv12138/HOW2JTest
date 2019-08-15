package tk.ddvudo.Geode;

import com.alibaba.fastjson.JSON;
import org.apache.geode.cache.Cache;
import org.apache.geode.cache.CacheFactory;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.RegionFactory;
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

import java.util.List;

public class Sample {
    static String regionName = "Enterprise";

    public static void main(String... args) {
        Logger logger = Logger.getRootLogger();
        try {
            Cache cache = new CacheFactory().create();
            ClientCache clientCache = new ClientCacheFactory().addPoolLocator("localhost", 10334).create();
            ClientRegionFactory regionFactory = clientCache.createClientRegionFactory(ClientRegionShortcut.CACHING_PROXY);
            Region region = regionFactory.create(regionName);
            logger.info(clientCache.getCurrentServers());
            region.put("1", "1");
            logger.info(region.get("1"));
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
            try (SqlSession session = sqlSessionFactory.openSession()) {
                EnterpriseDao enterMapper = session.getMapper(EnterpriseDao.class);
                EnterpriseExample enterpriseExample = new EnterpriseExample();
                enterpriseExample.setOrderByClause("id desc");
                enterpriseExample.setLimit(10);
                long count = enterMapper.countByExample(enterpriseExample);
                List<Enterprise> res = enterMapper.selectByExample(enterpriseExample);
                for (Enterprise enterprise : res) {
                    System.out.println("已处理id=" + enterprise.getId() + ",线程" + Thread.currentThread().getName());
                    region.put(enterprise.getKey(), JSON.toJSONString(enterprise));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
