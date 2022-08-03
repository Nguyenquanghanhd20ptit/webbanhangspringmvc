package laptrinh.Servicer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import laptrinh.dao.dangki_interface;
import laptrinh.modell.user;
import laptrinh.service.user_interface;

@Service
public class userService implements user_interface {
	@Autowired
	dangki_interface userDao;
	@Override
	public void insertUser(user T) {
		userDao.insertUser(T);
	}

	@Override
	public user selecttaikhoan(String taikhoan) {
	    return	userDao.selecttaikhoan(taikhoan);
	}

	@Override
	public user selectUser(String taikhoan, String password) {
		return userDao.selectUser(taikhoan, password);
	}

}
