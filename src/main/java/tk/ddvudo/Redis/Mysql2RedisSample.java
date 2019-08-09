package tk.ddvudo.Redis;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import redis.clients.jedis.Jedis;
import tk.ddvudo.Mybatis.JavaBeans.Enterprise;
import tk.ddvudo.Mybatis.JavaBeans.EnterpriseExample;
import tk.ddvudo.Mybatis.UseAnnotation.EnterpriseDao;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Mysql2RedisSample {
    private SqlSessionFactory sqlSessionFactory;
    private static String redisServer = "188.131.157.4";
    private static int redisPort = 6379;
    private static String redisAuth = "liukang951006";

    private Mysql2RedisSample() {
        try {
            String resource = "mybatis-config.xml";
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String... args) {
        clearCache();
        singleThread();
    }

    private static void clearCache() {
        Jedis jedis = new Jedis(redisServer, redisPort);
        jedis.auth(redisAuth);
        jedis.expire("Enterprise", 1);
    }

    private static void singleThread() {
        Mysql2RedisSample mysql2RedisSample = new Mysql2RedisSample();
        ExecutorService pool = Executors.newCachedThreadPool();
        try (SqlSession session = mysql2RedisSample.sqlSessionFactory.openSession()) {
            EnterpriseDao enterMapper = session.getMapper(EnterpriseDao.class);
            EnterpriseExample enterpriseExample = new EnterpriseExample();
            enterpriseExample.setOrderByClause("id desc");
            long count = enterMapper.countByExample(enterpriseExample);
            int pageSize = 1000;
            for (int i = 0; i * pageSize < count; i++) {
                long offset = (i * pageSize);
                enterpriseExample.setOffset(offset);
                enterpriseExample.setLimit(pageSize);
                List<Enterprise> res = enterMapper.selectByExample(enterpriseExample);
                pool.submit(() -> {
                    System.out.println("=====================================================================================");
                    Jedis jedis = new Jedis(redisServer, redisPort);
                    jedis.auth(redisAuth);
                    System.out.println(res.size());
                    for (Enterprise enterprise : res) {
                        System.out.println("已处理id=" + enterprise.getId() + ",线程" + Thread.currentThread().getName());
                        jedis.hsetnx("Enterprise", enterprise.getKey(), JSON.toJSONString(enterprise));
                        this.wait(100);
                    }
                });
            }
        } finally {
            pool.shutdown();
        }
    }

}
