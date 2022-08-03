package laptrinh.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import laptrinh.dao.Home_interface;
import laptrinh.modell.slides;

@Repository
public class slide_dao implements Home_interface<slides> {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public List<slides> selectALL() {
		String sql = "select * from slides";
		  return	jdbcTemplate.query(sql,new Object[] {},new RowMapper<slides>(){

				@Override
				public slides mapRow(ResultSet rs, int rowNum) throws SQLException {
					slides slides = new slides(rs.getInt("id"), rs.getString("img"), rs.getString("caption"), rs.getString("content"));
					return slides;
				}
			});
	}

}
