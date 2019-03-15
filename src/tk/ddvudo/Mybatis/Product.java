package tk.ddvudo.Mybatis;

import java.util.UUID;

public class Product {
    String id, name, cid;
    Float price;

    public Product(String name, String cid, Float price) {
        this.id = UUID.randomUUID().toString().replaceAll("-", "");
        this.name = name;
        this.cid = cid;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", cid='" + cid + '\'' +
                ", price=" + price +
                '}';
    }
}
