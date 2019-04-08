package tk.ddvudo.Mybatis.UseAnnotation;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import tk.ddvudo.Mybatis.JavaBeans.Category;
import tk.ddvudo.Mybatis.JavaBeans.Product;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

public class Sample {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        CategoryMapper cm = session.getMapper(CategoryMapper.class);
        Category c = cm.get("1");
        Product p = new Product("test", c, 12.65f);
        System.out.println(p);
        ProductMapper pm = session.getMapper(ProductMapper.class);
        System.out.println(pm.Insert(p));
        session.commit();
        session.close();

    }

    private static void update(CategoryMapper mapper) {
        Category c = mapper.get("8");
        c.setName("修改了的Category名稱");
        mapper.update(c);
        listAll(mapper);
    }

    private static void get(CategoryMapper mapper) {
        Category c = mapper.get("8");
        System.out.println(c.getName());
    }

    private static void delete(CategoryMapper mapper) {
        mapper.delete("2");
        listAll(mapper);
    }

    private static void add(CategoryMapper mapper) {
        Category c = new Category();
        c.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        c.setName("新增加的Category");
        mapper.add(c);
        listAll(mapper);
    }

    private static void listAll(CategoryMapper mapper) {
        List<Category> cs = mapper.list();
        for (Category c : cs) {
            System.out.println(c);
        }
    }
}
