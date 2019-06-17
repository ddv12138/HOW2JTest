package tk.ddvudo.Mybatis.JavaBeans;

import java.util.List;

public class Category {
    private String id;
    private String name;

    public List<Product> getProducts() {
        return products;
    }

    private List<Product> products;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        String sb = "{" + "\"id\":\"" +
                id + '\"' +
                ",\"name\":\"" +
                name + '\"' +
                ",\"products\":" +
                products +
                '}';
        return sb;
    }
}
