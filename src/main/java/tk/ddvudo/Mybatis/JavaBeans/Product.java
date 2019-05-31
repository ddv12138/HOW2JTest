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

}
