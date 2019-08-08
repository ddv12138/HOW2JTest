package tk.ddvudo.Redis;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import tk.ddvudo.Mybatis.JavaBeans.Enterprise;
import tk.ddvudo.Mybatis.JavaBeans.EnterpriseExample;
import tk.ddvudo.Mybatis.UseAnnotation.EnterpriseDao;

import java.io.IOException;

public class Mysql2RedisSample {
    private SqlSessionFactory sqlSessionFactory;
    private Jedis jedis;

    private Mysql2RedisSample() {
        try {
            String resource = "mybatis-config.xml";
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
            jedis = new Jedis("188.131.157.4", 6379);
            jedis.auth("liukang951006");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String... args) {
        Logger logger = LoggerFactory.getLogger(Mysql2RedisSample.class);
        logger.info("aaa");
        Mysql2RedisSample mysql2RedisSample = new Mysql2RedisSample();
        try (SqlSession session = mysql2RedisSample.sqlSessionFactory.openSession()) {
            EnterpriseDao enterMapper = session.getMapper(EnterpriseDao.class);
            EnterpriseExample enterpriseExample = new EnterpriseExample();
            long count = enterMapper.countByExample(enterpriseExample);
            int pageSize = 100 * 10000;
            for (int i = 0; i * pageSize < count; i++) {
                long offset = (i * pageSize);
                if (offset >= count) {
                    offset = count;
                }
                final long finalOffset = offset;
                new Thread(() -> {
                    try (SqlSession session_tmp = mysql2RedisSample.sqlSessionFactory.openSession()) {
                        EnterpriseDao enterMapper_tmp = session_tmp.getMapper(EnterpriseDao.class);
                        EnterpriseExample enterpriseExample_tmp = new EnterpriseExample();
                        enterpriseExample_tmp.setOffset(finalOffset);
                        System.out.println(finalOffset);
                        enterpriseExample_tmp.setLimit(pageSize);
                        enterMapper_tmp.selectByExample_Map_Forward(enterpriseExample_tmp, resultContext -> {
                            Enterprise enterprise = resultContext.getResultObject();
                            System.out.println("已处理id=" + enterprise.getId());
                            mysql2RedisSample.jedis.hsetnx("Enterprise", enterprise.getKey(), JSON.toJSONString(enterprise));
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).start();
            }
//            System.out.println(mysql2RedisSample.jedis.hgetAll("Enterprise"));
//            System.out.println(mysql2RedisSample.jedis.hget("Enterprise", "上海?"));
        }
    }
}
