package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author Lijie
 * @date 2017��12��4��
 */
public class DBManager {

	private static final String URL = "jdbc:mysql://172.26.67.208/mysql?useSSL=true";
	private static final String NAME = "root";
	private static final String PASSWORD = "lijie160582";
	private static Connection conn = null;
	private static final String driver = "com.mysql.jdbc.Driver";

	// �����ṩһ����������ȡ���ݿ�����
	public static Connection getConnection() {
		try {
			// 1.������������
			Class.forName(driver);
			// 2.������ݿ������
			conn = DriverManager.getConnection(URL, NAME, PASSWORD);
			
			if (!conn.isClosed())
				System.out.println("Succeeded connecting to the Database!");
		} catch (ClassNotFoundException e) {
			System.out.println("û���ҵ����ݿ���������");
		} catch (SQLException e) {
			System.out.println("���ݿ�����ʱ�����쳣�������������ݿ����δ������ɣ������������ݿ����");
		}
		return conn;
	}
}
