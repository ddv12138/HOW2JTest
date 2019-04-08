package tk.ddvudo.Mybatis.UseAnnotation;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.ddvudo.Mybatis.JavaBeans.OrderItem;
import tk.ddvudo.Mybatis.JavaBeans.Order;
import tk.ddvudo.Mybatis.JavaBeans.Product;

import java.util.List;

public interface OrderItemMapper {
    @Select("select * from order_item where oid = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "product", javaType = Product.class, column = "pid", one = @One(select = "tk.ddvudo.Mybatis.UseAnnotation.ProductMapper.getProductById")),
            @Result(property = "order", javaType = Order.class, column = "oid", one = @One(select = "tk.ddvudo.Mybatis.UseAnnotation.OrderMapper.getOrderById"))
    })
    List<OrderItem> listByOrder(String id);
}
