package laptrinh.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import laptrinh.dao.dangki_interface;
import laptrinh.modell.user;

@Repository
public class user_dao implements dangki_interface {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public void insertUser(user t) {
		String sql =  "insert into user(taikhoan,password,email,hoten,tuoi,diachi,sdt) value(?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,t.getTaikhoan(),t.getPassword(),t.getEmail(),t.getHoten(),t.getTuoi(),t.getDiachi(),t.getSdt());
	}

	@Override
	public user selecttaikhoan(String taikhoan) {
		String sql = "select * from user where taikhoan=? ";
    	List<user> listTaokhoan =	jdbcTemplate.query(sql, new Object[] {taikhoan}, new RowMapper<user>() {
			@Override
			public user mapRow(ResultSet rs, int rowNum) throws SQLException {
				user user = new user();
				user.setId(rs.getInt("id"));
				user.setTaikhoan(rs.getString("taikhoan"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setHoten(rs.getString("hoten"));
				user.setTuoi(rs.getInt("tuoi"));
				user.setDiachi(rs.getString("diachi"));
				user.setSdt(rs.getString("sdt"));
			    return user;
			}
		});
    	 if (listTaokhoan.isEmpty()) {
             return null;
         } 
    	 else  return listTaokhoan.get(0);
	}

	@Override
	public user selectUser(String taikhoan, String password) {
		String sql = "select * from user where taikhoan=? and password = ? ";
    	List<user> listTaokhoan =	jdbcTemplate.query(sql, new Object[] {taikhoan, password}, new RowMapper<user>() {
			@Override
			public user mapRow(ResultSet rs, int rowNum) throws SQLException {
				user user = new user();
				user.setId(rs.getInt("id"));
				user.setTaikhoan(rs.getString("taikhoan"));
				user.setPassword(rs.getString("password"));
				user.setHoten(rs.getString("hoten"));
				user.setEmail(rs.getString("email"));
				user.setTuoi(rs.getInt("tuoi"));
				user.setDiachi(rs.getString("diachi"));
				user.setSdt(rs.getString("sdt"));
			    return user;
			}
		});
    	 if (listTaokhoan.isEmpty()) {
             return null;
         } 
    	 else  return listTaokhoan.get(0);
	}

}
