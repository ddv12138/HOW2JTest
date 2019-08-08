package tk.ddvudo.Redis;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import tk.ddvudo.Mybatis.UseAnnotation.EnterpriseDao;

import java.io.IOException;
import java.util.Map;

public class Mysql2RedisSample {
    private String resource = "mybatis-config.xml";
    private SqlSessionFactory sqlSessionFactory;
    private Jedis jedis;

    public Mysql2RedisSample() {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
            jedis = new Jedis("188.131.157.4", 6379);
            jedis.auth("liukang951006");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String... args) {
        Logger logger = LoggerFactory.getLogger(Mysql2RedisSample.class);
        Mysql2RedisSample mysql2RedisSample = new Mysql2RedisSample();
        try (SqlSession session = mysql2RedisSample.sqlSessionFactory.openSession()) {
            EnterpriseDao enterMapper = session.getMapper(EnterpriseDao.class);
            Map enterprise = enterMapper.selectByPrimaryKey_Map(1);
            System.out.println(JSON.toJSONString(enterprise));
        }
    }
}
