package laptrinh.modell;

public class catecory {
	private int id;
	private String ten;
	private String description;
	public catecory(int id, String ten, String description) {
		super();
		this.id = id;
		this.ten = ten;
		this.description = description;
	}
	public catecory() {
		super();
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
