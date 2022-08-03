package laptrinh.modell;

public class bill {
	 private int id;
	 private String hoten;
	 private String email;
	 private String diachi;
	 private String sdt;
	 private double totalPrice;
	 private int quanty;
	 private String ghichu;
	public bill(int id, String hoten, String email, String diachi, String sdt, double totalPrice, int quanty,
			String ghichu) {
		super();
		this.id = id;
		this.hoten = hoten;
		this.email = email;
		this.diachi = diachi;
		this.sdt = sdt;
		this.totalPrice = totalPrice;
		this.quanty = quanty;
		this.ghichu = ghichu;
	}
	public bill() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getQuanty() {
		return quanty;
	}
	public void setQuanty(int quanty) {
		this.quanty = quanty;
	}
	public String getGhichu() {
		return ghichu;
	}
	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}
	 
	
}
