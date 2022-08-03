package laptrinh.service;

import java.util.HashMap;

import laptrinh.modell.bill;
import laptrinh.modell.cart;

public interface billService_interface {
	public void AddBills(bill t);
	public void AddBilldetail(HashMap<Integer, cart> Carts);
}
