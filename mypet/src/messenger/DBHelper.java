package messenger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
	
	private static final String DB_HOST = "localhost";
	private static final String DB_PORT = "3306";
	private static final String DB_DATADASE_NAME = "mypet";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "1234";
	
	private Connection conn;
	
	private DBHelper dbHelper;
	
	public DBHelper() {}
	
	public DBHelper getInstance() {
		if (dbHelper == null) {
			dbHelper = new DBHelper();
		}
		return dbHelper;
	}
	public Connection getConnection() {
		if (conn == null) {
			String urlFormat = "jdbc:mysql://%s:%s/%s?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";
			String url = String.format(urlFormat, DB_HOST,DB_PORT,DB_DATADASE_NAME);
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(url,DB_USER,DB_PASSWORD);
				System.out.println("DB연결완료");
			} catch (Exception e) {
				System.out.println("연결실패");
				e.printStackTrace();
			}
		}
		return conn;
	}
	public void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
