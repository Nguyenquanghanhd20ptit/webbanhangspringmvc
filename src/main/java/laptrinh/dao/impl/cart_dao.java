package laptrinh.dao.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import laptrinh.dao.Product_interface;
import laptrinh.modell.products;
import laptrinh.modell.cart;

@Repository
public class cart_dao {
	@Autowired
    JdbcTemplate jdbcTemplate;
	@Autowired
	Product_interface<products> productDao;
	
	public HashMap<Integer,cart> AddCart(int id,  HashMap<Integer,cart> Cart){
		cart cart = new cart();
		products product = productDao.selectById(id);
		if(product != null && Cart.containsKey(id)) {
		   cart = Cart.get(id);
		   cart.setQuanty(cart.getQuanty()+1);
		   cart.setTotalPrice(cart.getQuanty() * product.getPrice());
		}
		else {
			cart.setProduct(product);
			cart.setQuanty(1);
			cart.setTotalPrice(product.getPrice());
		}
		Cart.put(id, cart);
		return Cart;
	}
	public HashMap<Integer,cart> EditCart(int id,  int quanty,HashMap<Integer,cart> Cart){
		if (Cart == null) {
			return Cart;
		}
		cart cart = new cart();
		products product = productDao.selectById(id);
		if(Cart.containsKey(id)) {
			cart = Cart.get(id);
			cart.setQuanty(quanty);
		    cart.setTotalPrice(quanty * product.getPrice());
		}
		Cart.put(id, cart);
		return Cart;
	}
	public HashMap<Integer,cart> DeleteCart(int id, HashMap<Integer,cart> Cart){
		if (Cart == null) {
			return Cart;
		}
		if(Cart.containsKey(id)) {
			Cart.remove(id);
		}
		return Cart;
	}
	public int totalQuanty( HashMap<Integer,cart> Cart){
		int sum=0;
		for(Map.Entry<Integer, cart> itemCart : Cart.entrySet()) {
		    sum += itemCart.getValue().getQuanty();
		}
		return sum;
	}
    public double totalPrice( HashMap<Integer,cart> Cart){
    	double sum=0;
		for(Map.Entry<Integer, cart> itemCart:Cart.entrySet()) {
		    sum += itemCart.getValue().getTotalPrice();
		}
		return sum;
	}
}
