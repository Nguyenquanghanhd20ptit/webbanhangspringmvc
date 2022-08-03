package laptrinh.service;

import java.util.List;

import laptrinh.modell.products;

public interface category_interface {
	public List<products> getPaginates(int id,int start,int end);
	public List<products> selectALL_byIdPaginates(int id);
}
