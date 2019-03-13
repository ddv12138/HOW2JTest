package tk.ddvudo.JDBC.initDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class initTest {

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection c = DriverManager.getConnection("jdbc:mysql://ddvudo.tk:3306/mysql?characterEncoding=UTF-8",
                "root", "liukang951006"); Statement s = c.createStatement()) {
//			String sql = "insert into mytable (name,age,gender) values('" + "张三" + "','" + 18 + "','" + 1 + "')";
            String sql = "delete from mytable";
            s.execute(sql);
            for (int i = 0; i < 100; i++) {
                String tmp = "insert into mytable (name,age,gender) values('" + "张三" + i + "','" + 18 + "','" + 1 + "')";
                System.out.println(tmp);
                s.execute(tmp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
