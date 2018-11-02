package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnUtils {
	// goi ham nay de thuc hien chuong trinh
	public static Connection  getMySQLConnection() throws SQLException, ClassNotFoundException {
		String hostName = "localhost";
		String dbName = "qlkhachhang";
		String userName = "root";
		String password = "123456789";
	
		return getMySQLConnection(hostName, dbName, userName, password);
	}
	
	public static Connection getMySQLConnection(String hostName, String dbName, String userName, String password) throws SQLException,ClassNotFoundException {
	     
	     Class.forName("com.mysql.jdbc.Driver");
	     String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
	 
	     Connection conn =  DriverManager.getConnection(connectionURL, userName, password);
	     return conn;
	 }

}
