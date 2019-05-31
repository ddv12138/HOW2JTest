package tk.ddvudo.Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringSample {
    public static void main(String... args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"main/resources/applicationContext.xml"});
        MysqlDBQuery msbq = (MysqlDBQuery) context.getBean("MysqlDBQuery");
        msbq.randomInsetData();
    }
}
