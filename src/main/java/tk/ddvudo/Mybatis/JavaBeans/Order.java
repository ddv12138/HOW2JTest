package tk.ddvudo.Mybatis.JavaBeans;

import java.util.List;

public class Order {
    private String id;
    private String code;

    List<OrderItem> orderItems;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        String sb = "{" + "\"id\":" +
                id +
                ",\"code\":\"" +
                code + '\"' +
                ",\"orderItems\":" +
                orderItems +
                '}';
        return sb;
    }
}
