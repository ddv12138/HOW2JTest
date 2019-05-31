package tk.ddvudo.Spring;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Category {
    private String id;
    private String name = "default-category-name";

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
