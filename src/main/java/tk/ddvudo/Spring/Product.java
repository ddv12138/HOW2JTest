package tk.ddvudo.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Product {
    String id, name = "default-product-name", cid;
    Float price;

    public void setCategory(Category category) {
        this.category = category;
        this.cid = category.getId();
    }

    @Autowired
    Category category;

    public Product() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":\"")
                .append(id).append('\"');
        sb.append(",\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"cid\":\"")
                .append(cid).append('\"');
        sb.append(",\"price\":")
                .append(price);
        sb.append(",\"category\":")
                .append(category);
        sb.append('}');
        return sb.toString();
    }

    public Product(String name, Category category, Float price) {
        this.id = UUID.randomUUID().toString().replaceAll("-", "");
        this.name = name;
        this.cid = category.getId();
        this.category = category;
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

    public Category getCategory() {
        return category;
    }
}
