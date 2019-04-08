package tk.ddvudo.Mybatis.UseAnnotation;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.ddvudo.Mybatis.JavaBeans.Category;
import tk.ddvudo.Mybatis.JavaBeans.Product;

import java.util.List;


public interface ProductMapper {
    @Select("select * From Product where cid = #{0}")
    List<Product> listPorductByCategory(String id);

    @Select("select * From Product where id = #{0}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "cid", column = "cid"),
            @Result(property = "name", column = "name"),
            @Result(property = "category", javaType = Category.class, column = "cid", one = @One(select = "tk.ddvudo.Mybatis.UseAnnotation.CategoryMapper.get"))
    })
    List<Product> getProductById(String id);

    @Select("select * from Product")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "cid", column = "cid"),
            @Result(property = "name", column = "name"),
            @Result(property = "category", javaType = Category.class, column = "cid", one = @One(select = "tk.ddvudo.Mybatis.UseAnnotation.CategoryMapper.get"))
    })
    List<Product> list();
}
