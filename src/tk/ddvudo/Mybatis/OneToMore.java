package tk.ddvudo.Mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class OneToMore {
    public static void main(String... args) {
        String resource = "mybatis-config.xml";
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession session = null;
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
            session = sqlSessionFactory.openSession();
            Category c1 = new Category("分类一");
            Category c2 = new Category("分类二");
            System.out.println(session.insert("addCategory", c1));
            System.out.println(session.insert("addCategory", c2));
            session.commit();
        } catch (IOException e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            if (null != session) {
                session.close();
            }
        }
    }
}
