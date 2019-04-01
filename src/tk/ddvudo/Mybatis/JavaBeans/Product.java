package tk.ddvudo.Mybatis.JavaBeans;

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

    public Product(String name, String cid, Float price) {
        this.id = UUID.randomUUID().toString().replaceAll("-", "");
        this.name = name;
        this.cid = cid;
        this.price = price;
    }

}
