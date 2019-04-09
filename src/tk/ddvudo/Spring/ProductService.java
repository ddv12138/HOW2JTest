package tk.ddvudo.Spring;

import org.springframework.stereotype.Component;

@Component("ProductService")
public class ProductService {
    public void doSomeService() {
        System.out.println("service done!!");
    }
}
