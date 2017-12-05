package SIMSserver.src.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Lijie
 * @date 2017��12��4��
 */
public class DBConnection {

	private static final String URL = "jdbc:mysql://localhost:3306/mysql";
	private static final String NAME = "sims";
	private static final String PASSWORD = "plsw16";

	private static Connection conn = null;
	// ��̬����飨�������������������ݿ���뾲̬���У�
	static {
		try {
			// 1.������������
			Class.forName("com.mysql.jdbc.Driver");
			// 2.������ݿ������
			conn = DriverManager.getConnection(URL, NAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// �����ṩһ����������ȡ���ݿ�����
	public static Connection getConnection() {
		return conn;
	}
}
