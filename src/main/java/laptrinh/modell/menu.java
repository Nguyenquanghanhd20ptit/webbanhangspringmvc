package laptrinh.modell;

public class menu {
	private int id;
	private String ten;
	private String url;
	public menu(int id, String ten, String url) {
		super();
		this.id = id;
		this.ten = ten;
		this.url = url;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
