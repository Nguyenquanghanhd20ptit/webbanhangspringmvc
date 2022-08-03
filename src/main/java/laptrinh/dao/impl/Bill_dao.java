package laptrinh.dao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import laptrinh.dao.bill_interface;
import laptrinh.modell.bill;
import laptrinh.modell.billDetail;

@Repository
public class Bill_dao implements bill_interface{
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public void AddBills(bill t) {
		String sql = "insert into bill(hoten, email, diachi,sdt,totalPrice,quanty,ghichu) value(?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,t.getHoten(),t.getEmail(),t.getDiachi(),t.getSdt(),t.getTotalPrice(),t.getQuanty(),t.getGhichu());
	}
	
	@Override
	public int getIdLastBill() {
		String sql = "select max(id) from bill";
	    return jdbcTemplate.queryForObject(sql,new Object[] {}, int.class);
	}
	@Override
	public void AddBillDetail(billDetail t) {
		String sql = "insert into billdetail(id_bill,id_product,quanty,totalPrice) value(?,?,?,?)";
		jdbcTemplate.update(sql,t.getId_bill(),t.getId_product(),t.getQuanty(),t.getTotalPrice());
	}


}
