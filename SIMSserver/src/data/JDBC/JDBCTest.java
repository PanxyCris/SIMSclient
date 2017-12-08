package SIMSserver.src.data.JDBC;

import java.sql.*;
import java.util.*;

public class JDBCTest {

	public Connection getConnection() throws Exception{
		String driverClass = "com.mysql.jdbc.Driver";
		String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/ssh";
		String user = "root";
		String password = "root";

		Driver driver = (Driver) Class.forName(driverClass).newInstance();
		Properties info = new Properties();
		info.put("user", user);
		info.put("password", password);
		Connection conn = driver.connect(jdbcUrl, info);
		return conn;

	}

	public static void main(String[] args) throws Exception{
		JDBCTest test = new JDBCTest();
		System.out.println(test.getConnection());
	}

}
