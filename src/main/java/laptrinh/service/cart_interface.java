package laptrinh.service;

import java.util.HashMap;

import laptrinh.modell.cart;

public interface cart_interface {
	public HashMap<Integer,cart> AddCart(int id,  HashMap<Integer,cart> Cart);
	public HashMap<Integer,cart> EditCart(int id,  int quanty,HashMap<Integer,cart> Cart);
	public HashMap<Integer,cart> DeleteCart(int id, HashMap<Integer,cart> Cart);
	public int totalQuanty( HashMap<Integer,cart> Cart);
	public double totalPrice( HashMap<Integer,cart> Cart);
}
