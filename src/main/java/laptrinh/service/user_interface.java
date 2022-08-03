package laptrinh.service;

import laptrinh.modell.user;

public interface user_interface {
	public void insertUser(user T);
	public user selecttaikhoan(String taikhoan);
	public user selectUser (String taikhoan, String password);

}
