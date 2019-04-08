package tk.ddvudo.Mybatis.UseAnnotation;

import org.apache.ibatis.jdbc.SQL;

public class CategoryDynaSqlProvider {
    public String list() {
        return new SQL().SELECT("*").FROM("Category").toString();
    }

    public String getById(String id) {
        return new SQL().SELECT("*").FROM("Category").WHERE("id=#{id}").toString();
    }
}
