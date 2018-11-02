package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection connection = (Connection) MySQLConnUtils.getMySQLConnection();
		Statement statement = connection.createStatement();
		String sql = "SELECT * FROM hachhang";
		ResultSet resultSet = statement.executeQuery(sql);
		KhachHang hang;
		while(resultSet.next()) {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("tenKH");
			String diachi = resultSet.getString("diachi");
			double luong = resultSet.getDouble("luong");
			hang = new KhachHang(id, name, diachi, luong);
			System.out.println(hang.toString());
			
		}

	}

}
