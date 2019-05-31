package tk.ddvudo.Spring;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;
import tk.ddvudo.Mybatis.JavaBeans.Product;
import tk.ddvudo.Mybatis.UseAnnotation.ProductMapper;

import java.io.InputStream;

@Component("MysqlDBQuery")
public class MysqlDBQuery {
    public int randomInsetData() throws Exception {
        String resource = "main/resources/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ProductMapper pm = session.getMapper(ProductMapper.class);
            int count = 0;
            while (count < 10) {
                count += pm.Insert(new Product("performance-test", new Category(), 0.02f));
            }
            session.commit();
        }
        return 0;
    }
}
