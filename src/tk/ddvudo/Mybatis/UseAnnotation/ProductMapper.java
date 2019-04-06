package tk.ddvudo.Mybatis.UseAnnotation;

import org.apache.ibatis.annotations.Select;
import tk.ddvudo.Mybatis.JavaBeans.Product;

import java.util.List;


public interface ProductMapper {
    @Select("select * From Product where cid = #{0}")
    List<Product> listPorductByCategory(String id);
}
