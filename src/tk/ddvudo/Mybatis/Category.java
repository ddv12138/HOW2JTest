package tk.ddvudo.Mybatis;

import java.util.UUID;

public class Category {
    String id;
    String name;

    public Category(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(String name) {
        this.id = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(this.id);
        this.name = name;
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

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
