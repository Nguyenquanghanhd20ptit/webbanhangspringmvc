package laptrinh.modell;

public class billDetail {
	private int id;
	private int id_bill;
	private int id_product;
	private int quanty;
	private double totalPrice;
	public billDetail(int id, int id_bill, int id_product, int quanty, double totalPrice) {
		super();
		this.id = id;
		this.id_bill = id_bill;
		this.id_product = id_product;
		this.quanty = quanty;
		this.totalPrice = totalPrice;
	}
	public billDetail() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_bill() {
		return id_bill;
	}
	public void setId_bill(int id_bill) {
		this.id_bill = id_bill;
	}
	public int getId_product() {
		return id_product;
	}
	public void setId_product(int id_product) {
		this.id_product = id_product;
	}
	public int getQuanty() {
		return quanty;
	}
	public void setQuanty(int quanty) {
		this.quanty = quanty;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
