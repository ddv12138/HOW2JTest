package tk.ddvudo.Mybatis.JavaBeans;

import java.util.UUID;

public class Product {
    String id, name, cid;
    Float price;

    public void setCategory(Category category) {
        this.category = category;
        this.cid = category.getId();
    }

    Category category;

    public Product(String test, tk.ddvudo.Spring.Category c, float price) {
    }

    @Override
    public String toString() {
        String sb = "{" + "\"id\":\"" +
                id + '\"' +
                ",\"name\":\"" +
                name + '\"' +
                ",\"cid\":\"" +
                cid + '\"' +
                ",\"price\":" +
                price +
                ",\"category\":" +
                category +
                '}';
        return sb;
    }

    public Product(String name, Category category, Float price) {
        this.id = UUID.randomUUID().toString().replaceAll("-", "");
        this.name = name;
        this.cid = category.getId();
        this.category = category;
        this.price = price;
    }

}
