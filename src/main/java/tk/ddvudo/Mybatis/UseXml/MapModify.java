package tk.ddvudo.Mybatis.UseXml;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import tk.ddvudo.Mybatis.JavaBeans.Category;
import tk.ddvudo.Mybatis.JavaBeans.Product;


public class MapModify {
    public static void main(String... args) {
        String resource = "main/resources/mybatis-config.xml";
        SqlSessionFactory sqlSessionFactory;
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
            try (SqlSession session = sqlSessionFactory.openSession()) {
                Product p5 = session.selectOne("getProduct", "5");
                Category c1 = session.selectOne("getCategory", "1");
                p5.setCategory(c1);
                session.update("updateProduct", p5);
                session.commit();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
