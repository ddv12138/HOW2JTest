package tk.ddvudo.Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringSample {
    public static void main(String... args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
        ProductService ps = (ProductService) context.getBean("ProductService");
        ps.doSomeService();
    }
}
