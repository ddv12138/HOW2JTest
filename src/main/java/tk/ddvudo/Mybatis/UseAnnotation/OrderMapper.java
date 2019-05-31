package tk.ddvudo.Mybatis.UseAnnotation;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.ddvudo.Mybatis.JavaBeans.Order;

import java.util.List;

public interface OrderMapper {
    @Select("select * From `order`")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "code", column = "code"),
            @Result(property = "orderItems", column = "id", javaType = List.class, many = @Many(select = "OrderItemMapper.listByOrder"))
    })
    List<Order> list();

    @Select("select * From `order` where id = #{0}")
    Order getOrderById(String id);
}
