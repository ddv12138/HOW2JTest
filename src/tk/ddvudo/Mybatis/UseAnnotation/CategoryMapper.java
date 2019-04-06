package tk.ddvudo.Mybatis.UseAnnotation;


import org.apache.ibatis.annotations.*;
import tk.ddvudo.Mybatis.JavaBeans.Category;

import java.util.List;

public interface CategoryMapper {
    @Insert(" insert into Category (id, name ) values (#{id},#{name}) ")
    int add(Category category);

    @Delete(" delete from Category where id= #{id} ")
    void delete(int id);

    @Select("select * from Category where id= #{id} ")
    Category get(int id);

    @Update("update Category set name=#{name} where id=#{id} ")
    int update(Category category);

    @Select(" select * from Category ")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "products", javaType = List.class, column = "id", many = @Many(select = "tk.ddvudo.Mybatis.UseAnnotation.ProductMapper.listPorductByCategory"))
    })
    List<Category> list();
}
