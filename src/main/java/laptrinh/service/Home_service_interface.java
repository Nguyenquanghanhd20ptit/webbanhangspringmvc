package laptrinh.service;

import java.util.List;

import laptrinh.modell.catecory;
import laptrinh.modell.menu;
import laptrinh.modell.products;
import laptrinh.modell.slides;

public interface Home_service_interface {
	public List<slides> selectALL_slide();
	public List<catecory> selectALL_category();
	public List<menu> selectALL_menu();
	public List<products> selectALL_newProduct();
	public List<products> selectALL_nbProduct();
	public products selectById_Product(int id);
	public List<products> selectALL_Productlq(int id);
}
