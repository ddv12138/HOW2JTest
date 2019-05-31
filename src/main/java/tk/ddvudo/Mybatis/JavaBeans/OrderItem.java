package tk.ddvudo.Mybatis.JavaBeans;

public class OrderItem {
    private int id;
    private int number;
    private Order order;
    private Product product;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"number\":")
                .append(number);
        sb.append(",\"order\":")
                .append(order);
        sb.append(",\"product\":")
                .append(product);
        sb.append('}');
        return sb.toString();
    }
}
