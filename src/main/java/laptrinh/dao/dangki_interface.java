package laptrinh.dao;

import laptrinh.modell.user;

public interface dangki_interface {
	public void insertUser(user T);
	public user selecttaikhoan(String taikhoan);
	public user selectUser (String taikhoan, String password);
}
