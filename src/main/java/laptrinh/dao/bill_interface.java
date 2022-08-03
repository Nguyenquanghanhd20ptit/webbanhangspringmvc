package laptrinh.dao;

import laptrinh.modell.bill;
import laptrinh.modell.billDetail;

public interface bill_interface {
	public void AddBills(bill t);
	public int getIdLastBill(); 
	public void AddBillDetail (billDetail t);
}
