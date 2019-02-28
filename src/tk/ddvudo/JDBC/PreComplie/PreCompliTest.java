package tk.ddvudo.JDBC.PreComplie;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PreCompliTest {

	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String sql = "select * From mytable";
		try (Connection c = DriverManager.getConnection("jdbc:mysql://ddvudo.tk:3306/mysql?characterEncoding=UTF-8",
				"root", "liukang951006");
				PreparedStatement ps = c.prepareStatement(sql);) {
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				System.out.println(rs.getString("id")+"---"+rs.getString("name")+"---"+rs.getString("age")+"---"+rs.getString("gender"));
//			}
			// 查看数据库层面的元数据
            // 即数据库服务器版本，驱动版本，都有哪些数据库等等
  
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private static void getDataBaseMetaData() throws SQLException {
		try (Connection c = DriverManager.getConnection("jdbc:mysql://ddvudo.tk:3306/mysql?characterEncoding=UTF-8",
				"root", "liukang951006");){
			DatabaseMetaData dbmd = c.getMetaData();
			  
	        // 获取数据库服务器产品名称
	        System.out.println("数据库产品名称:\t"+dbmd.getDatabaseProductName());
	        // 获取数据库服务器产品版本号
	        System.out.println("数据库产品版本:\t"+dbmd.getDatabaseProductVersion());
	        // 获取数据库服务器用作类别和表名之间的分隔符 如test.user
	        System.out.println("数据库和表分隔符:\t"+dbmd.getCatalogSeparator());
	        // 获取驱动版本
	        System.out.println("驱动版本:\t"+dbmd.getDriverVersion());

	        System.out.println("可用的数据库列表：");
	        // 获取数据库名称
	        ResultSet rs = dbmd.getCatalogs();

	        while (rs.next()) {
	            System.out.println("数据库名称:\t"+rs.getString(1));
	        }
		}
	}

	@SuppressWarnings("unused")
	private static void performencetest() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String sql = "insert into mytable (name,age,gender) values(?,?,?)";
		try (Connection c = DriverManager.getConnection("jdbc:mysql://ddvudo.tk:3306/mysql?characterEncoding=UTF-8",
				"root", "liukang951006");
				PreparedStatement ps = c.prepareStatement(sql);
				Statement s = c.createStatement()) {
			long t1 = System.currentTimeMillis();
			for (int i = 0; i < 100; i++) {
				ps.setString(1, "test" + i);
				ps.setInt(2, i);
				ps.setInt(3, 1);
				ps.execute();
			}
			long t2 = System.currentTimeMillis();
			System.out.println(t2 - t1);
			for (int i = 0; i < 100; i++) {
				String tmp = "insert into mytable (name,age,gender) values('" + "张三" + i + "','" + 18 + "','" + 1
						+ "')";
				s.execute(tmp);
			}
			long t3 = System.currentTimeMillis();
			System.out.println(t3 - t2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static ResultSet list(int start, int count) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		try (Connection c = DriverManager.getConnection("jdbc:mysql://ddvudo.tk:3306/mysql?characterEncoding=UTF-8",
				"root", "liukang951006"); Statement s = c.createStatement();) {
			String sql = "select * From mytable limit " + start + "," + count + "";
			System.out.println(sql);
			if (s.execute(sql)) {
				ResultSet rs = s.getResultSet();
				while (rs.next()) {
					System.out.println(rs.getString("id") + "---" + rs.getString("name") + "---" + rs.getString("age")
							+ "---" + rs.getString("gender"));
				}
				return rs;
			}
			;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
