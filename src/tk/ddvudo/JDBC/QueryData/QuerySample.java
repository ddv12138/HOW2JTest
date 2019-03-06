package tk.ddvudo.JDBC.QueryData;

import java.sql.*;

public class QuerySample {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        list(10, 10);
    }

    public static ResultSet list(int start, int count) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection c = DriverManager.getConnection("jdbc:mysql://ddvudo.tk:3306/mysql?characterEncoding=UTF-8",
                "root", "liukang951006"); Statement s = c.createStatement()) {
            String sql = "select * From mytable limit " + start + "," + count + "";
            System.out.println(sql);
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString("id") + "---" + rs.getString("name") + "---" + rs.getString("age") + "---" + rs.getString("gender"));
            }
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
