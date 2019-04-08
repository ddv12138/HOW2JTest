package tk.ddvudo.Mybatis.UseAnnotation;


import org.apache.ibatis.annotations.*;
import tk.ddvudo.Mybatis.JavaBeans.Category;

import java.util.List;

public interface CategoryMapper {
    @Insert(" insert into Category (id, name ) values (#{id},#{name}) ")
    int add(Category category);

    @Delete(" delete from Category where id= #{id} ")
    void delete(String id);

    @SelectProvider(type = CategoryDynaSqlProvider.class, method = "getById")
    Category get(String id);

    @Update("update Category set name=#{name} where id=#{id} ")
    int update(Category category);

    @SelectProvider(type = CategoryDynaSqlProvider.class, method = "list")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "products", javaType = List.class, column = "id", many = @Many(select = "tk.ddvudo.Mybatis.UseAnnotation.ProductMapper.listPorductByCategory"))
    })
    List<Category> list();
}
