package laptrinh.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import laptrinh.dao.Home_interface;
import laptrinh.modell.menu;

@Repository
public class menu_dao implements Home_interface<menu>{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public List<menu> selectALL() {
		String sql = "select * from menu";
		  return	jdbcTemplate.query(sql,new Object[] {},new RowMapper<menu>(){

				@Override
				public menu mapRow(ResultSet rs, int rowNum) throws SQLException {
					menu menu = new menu(rs.getInt("id"), rs.getString("ten"), rs.getString("url"));
			        return menu;
				}
			});
	}

}
