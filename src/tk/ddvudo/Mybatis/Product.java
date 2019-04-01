package tk.ddvudo.Mybatis;


public class Product {
    String id, name, cid;
    Float price;

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
