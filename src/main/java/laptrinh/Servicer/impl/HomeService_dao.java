package laptrinh.Servicer.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import laptrinh.dao.Home_interface;
import laptrinh.dao.Product_interface;
import laptrinh.modell.catecory;
import laptrinh.modell.menu;
import laptrinh.modell.products;
import laptrinh.modell.slides;
import laptrinh.service.Home_service_interface;

@Service
public class HomeService_dao implements Home_service_interface {
	@Autowired
	Home_interface<slides> slidesDao;
	@Autowired
	Home_interface<menu> menuDao;
	@Autowired
	Home_interface<catecory> categoryDao;
	@Autowired
	Home_interface<products> newProductDao;
	@Autowired
	Product_interface<products> ProductDao;
	@Override
	public List<slides> selectALL_slide() {
		return slidesDao.selectALL();
	}

	@Override
	public List<catecory> selectALL_category() {
		return categoryDao.selectALL();
	}

	@Override
	public List<menu> selectALL_menu() {
		return menuDao.selectALL();
	}

	@Override
	public List<products> selectALL_newProduct() {
		return newProductDao.selectALL();
	}

	@Override
	public List<products> selectALL_nbProduct() {
		return ProductDao.selectALL_nb();
	}

	@Override
	public products selectById_Product(int id) {
		return ProductDao.selectById(id);
	}

	@Override
	public List<products> selectALL_Productlq(int id) {
		return ProductDao.selectALLProduct_lienquan(id);
	}
	
}
