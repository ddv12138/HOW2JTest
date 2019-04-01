package tk.ddvudo.Mybatis.JavaBeans;

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
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":\"")
                .append(id).append('\"');
        sb.append(",\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"products\":")
                .append(products);
        sb.append('}');
        return sb.toString();
    }
}
