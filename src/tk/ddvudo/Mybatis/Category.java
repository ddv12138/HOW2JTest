package tk.ddvudo.Mybatis;

import java.util.List;

public class Category {
    private String id;
    private String name;

    public List<Product> getProducts() {
        return products;
    }

    private List<Product> products;

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}
