package laptrinh.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import laptrinh.dao.Home_interface;
import laptrinh.modell.catecory;

@Repository
public class category_dao implements Home_interface<catecory>{
	@Autowired 
	JdbcTemplate jdbcTemplate;

	@Override
	public List<catecory> selectALL() {
		String sql= "select * from category";
		return jdbcTemplate.query(sql, new Object[] {},new RowMapper<catecory>(){

			@Override
			public catecory mapRow(ResultSet rs, int rowNum) throws SQLException {
				catecory catecory = new catecory(rs.getInt("id"), rs.getString("ten"), rs.getString("description"));
				return catecory;
			}
			
		});
	}
	
}
