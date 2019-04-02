package tk.ddvudo.Mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import tk.ddvudo.Mybatis.JavaBeans.Order;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class IfTag {
    public static void main(String... args) {
        String resource = "mybatis-config.xml";
        SqlSessionFactory sqlSessionFactory;
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
            try (SqlSession session = sqlSessionFactory.openSession()) {
                Map<String, Object> par = new LinkedHashMap<>();
                par.put("oid", "1");
                List<Order> orders = session.selectList("listOrder", par);
                System.out.println(orders);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
