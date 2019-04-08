package tk.ddvudo.Mybatis.UseAnnotation;

import org.apache.ibatis.jdbc.SQL;

public class ProductDynaSqlProvider {
    public String add() {
        return new SQL().INSERT_INTO("Product").INTO_COLUMNS("id,name,price,cid").INTO_VALUES("#{id},#{name},#{price},#{cid}").toString();
    }
}
