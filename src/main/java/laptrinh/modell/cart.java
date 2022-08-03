package laptrinh.modell;

import javax.management.loading.PrivateClassLoader;

public class cart {
	private int quanty;
	private double totalPrice;
	private products product;
	public cart(int quanty, double totalPrice, products product) {
		super();
		this.quanty = quanty;
		this.totalPrice = totalPrice;
		this.product = product;
	}
	public cart() {
		super();
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
	public products getProduct() {
		return product;
	}
	public void setProduct(products product) {
		this.product = product;
	}
}
