package JDBC.GUI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import JDBC.KhachHang;
import JDBC.MySQLConnUtils;

public class DataObject {
	public static ArrayList<KhachHangBean> data() throws ClassNotFoundException, SQLException {
		Connection connection = (Connection) MySQLConnUtils.getMySQLConnection();
		Statement statement = connection.createStatement();
		String sql = "SELECT * FROM hachhang";
		ResultSet resultSet = statement.executeQuery(sql);
		ArrayList<KhachHangBean> arrayList = new ArrayList<KhachHangBean>();
		while(resultSet.next()) {
			KhachHangBean hang = new KhachHangBean();
			int id = resultSet.getInt("id");
			hang.setId(id);
			String name = resultSet.getString("tenKH");
			hang.setName(name);
			String diachi = resultSet.getString("diachi");
			hang.setDiachi(diachi);
			double luong = resultSet.getDouble("luong");
			hang.setLuong(luong);
			arrayList.add(hang);
			System.out.println(hang.toString());
		}
		return arrayList;
	}
}
