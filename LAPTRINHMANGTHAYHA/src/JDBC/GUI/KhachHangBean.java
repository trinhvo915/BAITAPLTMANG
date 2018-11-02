package JDBC.GUI;

public class KhachHangBean {
	private Integer id;
	private String name;
	private String diachi;
	private double luong;
	
	public KhachHangBean() {
		
	}

	public KhachHangBean(Integer id, String name, String diachi, double luong) {
		this.id = id;
		this.name = name;
		this.diachi = diachi;
		this.luong = luong;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}
	@Override
	public String toString() {
		return "Id : "+id+" - Ten : "+this.name+" - Dia Chi : "+this.diachi+" - Luong : "+this.luong;
	}

}
