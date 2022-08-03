package laptrinh.Servicer.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import laptrinh.dao.impl.cart_dao;
import laptrinh.modell.cart;
import laptrinh.service.cart_interface;

@Service
public class cartServie implements cart_interface {
	@Autowired
	private cart_dao cartDao = new cart_dao();

	@Override
	public HashMap<Integer, cart> AddCart(int id, HashMap<Integer, cart> Cart) {
		return cartDao.AddCart(id, Cart);
	}

	@Override
	public HashMap<Integer, cart> EditCart(int id, int quanty, HashMap<Integer, cart> Cart) {
		return cartDao.EditCart(id, quanty, Cart);
	}

	@Override
	public HashMap<Integer, cart> DeleteCart(int id, HashMap<Integer, cart> Cart) {
		return cartDao.DeleteCart(id, Cart);
	}

	@Override
	public int totalQuanty(HashMap<Integer, cart> Cart) {
		return cartDao.totalQuanty(Cart);
	}

	@Override
	public double totalPrice(HashMap<Integer, cart> Cart) {
		return cartDao.totalPrice(Cart);
	}
}
