package tk.ddvudo.Geode;

import com.alibaba.fastjson.JSON;
import org.apache.geode.cache.*;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.apache.ibatis.cache.decorators.LoggingCache;
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
            ClientCache cache = new ClientCacheFactory().addPoolLocator("localhost", 10334).set("log-level", "ERROR").create();
            ClientRegionFactory rf = cache.createClientRegionFactory(ClientRegionShortcut.PROXY);
            Region region = rf.create(regionName);
            region.clear();
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
            try (SqlSession session = sqlSessionFactory.openSession()) {
                EnterpriseDao enterMapper = session.getMapper(EnterpriseDao.class);
                EnterpriseExample enterpriseExample = new EnterpriseExample();
                enterpriseExample.setOrderByClause("id desc");
                enterpriseExample.setLimit(10000);
                long count = enterMapper.countByExample(enterpriseExample);
                List<Enterprise> res = enterMapper.selectByExample(enterpriseExample);
                for (Enterprise enterprise : res) {
                    System.out.println("已处理id=" + enterprise.getId() + ",线程" + Thread.currentThread().getName());
                    region.put(enterprise.getKey(), enterprise);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
