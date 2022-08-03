package laptrinh.modell;

public class user {
	private int id;
	private String taikhoan;
	private String password;
	private String email;
	private String hoten;
	private int tuoi;
	private String diachi;
	private String sdt;
	
	
	
	public user(int id, String taikhoan, String password, String email, String hoten, int tuoi, String diachi,
			String sdt) {
		super();
		this.id = id;
		this.taikhoan = taikhoan;
		this.password = password;
		this.email = email;
		this.hoten = hoten;
		this.tuoi = tuoi;
		this.diachi = diachi;
		this.sdt = sdt;
	}


	public user() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTaikhoan() {
		return taikhoan;
	}


	public void setTaikhoan(String taikhoan) {
		this.taikhoan = taikhoan;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getHoten() {
		return hoten;
	}


	public void setHoten(String hoten) {
		this.hoten = hoten;
	}


	public int getTuoi() {
		return tuoi;
	}


	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}


	public String getDiachi() {
		return diachi;
	}


	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}


	public String getSdt() {
		return sdt;
	}


	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	
	
}
