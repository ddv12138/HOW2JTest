package tk.ddvudo.Mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MybatisTest {
    public static void main(String... args) {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession();
            List<MytableEntityBean> cs = session.selectList("listMytable");
            for (MytableEntityBean c : cs) {
                System.out.println(c.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
