package laptrinh.Servicer.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import laptrinh.dao.bill_interface;
import laptrinh.modell.bill;
import laptrinh.modell.billDetail;
import laptrinh.modell.cart;
import laptrinh.service.billService_interface;

@Service
public class billService implements billService_interface {
	@Autowired
	bill_interface billDao;
	@Override
	public void AddBills(bill t) {
		billDao.AddBills(t);
	}

	@Override
	public void AddBilldetail(HashMap<Integer, cart> Carts) {
		int id_bill = billDao.getIdLastBill();
		for(Map.Entry<Integer, cart> itemCart:Carts.entrySet()) {
		    billDetail billDetail = new billDetail();
		    billDetail.setId_bill(id_bill);
		    billDetail.setId_product(itemCart.getValue().getProduct().getId_product());
		    billDetail.setQuanty(itemCart.getValue().getQuanty());
		    billDetail.setTotalPrice(itemCart.getValue().getTotalPrice());
		    billDao.AddBillDetail(billDetail);
		}
	}

}
