package cn.edu.nuc.corejava;
/**
 * 数据库实用类
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	// 获得连接、打开连接，这就是JDBC技术
	public static Connection getConnection() {
		Connection conn = null;//数据库连接
		try {
			// 注册驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 数据库的连接字符串
			String url = "jdbc:mysql://localhost:3307/nuc712db?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false";
			conn = DriverManager.getConnection(url,"root","ROOT");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	// 关闭连接
	public static void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}







