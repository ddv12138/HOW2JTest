package tk.ddvudo.Mybatis;

import java.util.UUID;

public class Product {
    String id, name, cid;
    Float price;

    public void setCategory(Category category) {
        this.category = category;
    }

    Category category;

    public Product() {
    }

    public Product(String name, String cid, Float price) {
        this.id = UUID.randomUUID().toString().replaceAll("-", "");
        this.name = name;
        this.cid = cid;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", cid='" + cid + '\'' +
                ", price=" + price +
                ", category=" + category.toString() +
                '}';
    }
}
