package laptrinh.Servicer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import laptrinh.dao.Product_interface;
import laptrinh.modell.paginates;
import laptrinh.modell.products;
import laptrinh.service.Paginates_interface;
import laptrinh.service.category_interface;

@Service
public class categoryService implements category_interface {
	@Autowired
	Product_interface<products> productDao;
	@Autowired 
	Paginates_interface paginatesDao;
	@Override
	public List<products> getPaginates(int id,int start, int end) {
		return productDao.selectALL_paginates(id, start, end);
	}
	
	@Override
	public List<products> selectALL_byIdPaginates(int id) {
		return productDao.selectALL_byId(id);
	}


}
