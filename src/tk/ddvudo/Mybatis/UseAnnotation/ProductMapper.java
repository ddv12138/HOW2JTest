package tk.ddvudo.Mybatis.UseAnnotation;

import org.apache.ibatis.annotations.Select;
import tk.ddvudo.Mybatis.JavaBeans.Product;

import java.util.List;


public interface ProductMapper {
    @Select("select * From Product where cid = #{cid}")
    List<Product> listPorductByCategory(String cid);
}
