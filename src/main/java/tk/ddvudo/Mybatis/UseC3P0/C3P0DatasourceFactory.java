package tk.ddvudo.Mybatis.UseC3P0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

public class C3P0DatasourceFactory extends UnpooledDataSourceFactory {
    public C3P0DatasourceFactory() {
        this.dataSource = new ComboPooledDataSource();
    }
}
