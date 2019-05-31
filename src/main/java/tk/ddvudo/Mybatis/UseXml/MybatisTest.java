package tk.ddvudo.Mybatis.UseXml;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import tk.ddvudo.Mybatis.JavaBeans.dictionary;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MybatisTest {
    public static void main(String... args) {
        MybatisTest mt = new MybatisTest();
        String resource = "main/resources/mybatis-config.xml";
        SqlSessionFactory sqlSessionFactory = null;
        SqlSession session = null;
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
            session = sqlSessionFactory.openSession();
            //add
            dictionary dict = new dictionary(mt.getRandomString(5), mt.getRandomString(5));
            int res = session.insert("addDictionary", dict);
            System.out.println("add--->" + res);
            //delete
            dict = new dictionary();
            dict.setId(1);
            System.out.println("delete--->" + session.delete("deleteDictionary", dict));
            //update
            dict = new dictionary("1+1", "qqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
            dict.setId(2);
            System.out.println("update--->" + session.update("updateDictionary", dict));
            //list
            List<dictionary> cs = session.selectList("listDictionary");
//            for (dictionary c : cs) {
//                System.out.println(c.toString());
//            }
            //getByReceive
            cs = session.selectList("getDictionaryByReceive", "+");
//            for (dictionary c : cs) {
//                System.out.println(c.toString());
//            }
            //getDictionaryByReceiveWhenIdBigThan
            Map<String, Object> pars = new HashMap<>();
            pars.put("id", 5);
            pars.put("receive", "+");
            cs = session.selectList("getDictionaryByReceiveWhenIdBigThan", pars);
            for (dictionary c : cs) {
                System.out.println(c.toString());
            }
//            session.commit();

        } catch (IOException e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            if (null != session) {
                session.close();
            }
        }
    }

    public String getRandomString(int length) {
        String str = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm123456789`~!@#$%^&*()_+-=[]\\{}|;':\",./<>?";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; ++i) {
            int number = random.nextInt(str.length() - 1);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
