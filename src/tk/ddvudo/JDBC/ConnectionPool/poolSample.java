package tk.ddvudo.JDBC.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class poolSample {

    public static void main(String[] args) throws SQLException {
        MYConnectionPool pool = new MYConnectionPool(10);
        Connection c = pool.getConnection();
        String sql = "select * From mytable;";
        PreparedStatement ps = c.prepareStatement(sql);
        ResultSet rs = ps.executeQuery("select * From mytable;");
        while (rs.next()) {
            System.out.println(rs.getString("id") + "---" + rs.getString("name") + "---" + rs.getString("age")
                    + "---" + rs.getString("gender"));
        }
        pool.cLoseConnection(c);
    }

}
