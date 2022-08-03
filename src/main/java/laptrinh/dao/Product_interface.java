package laptrinh.dao;

import java.util.List;



public interface Product_interface<T> {
	public List<T> selectALL_nb();
	public List<T> selectALL_paginates(int id,int start,int end);
	public List<T> selectALL_byId(int id);
	public T selectById(int id);
	public List<T> selectALLProduct_lienquan(int id);
}
