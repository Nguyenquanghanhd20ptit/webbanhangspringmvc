package laptrinh.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import laptrinh.dao.Home_interface;
import laptrinh.modell.products;

@Repository
public class new_product_dao implements Home_interface<products>{
	@Autowired
	JdbcTemplate jdbcTemplate;
	

	private String SqlString() {
		StringBuffer  sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("p.id as id_product ");
		sql.append(", p.id_category ");
		sql.append(", p.size ");
		sql.append(", p.ten ");
		sql.append(", p.price ");
		sql.append(", p.sale ");
		sql.append(", p.title ");
		sql.append(", p.highlight ");
		sql.append(", p.new_product ");
		sql.append(", p.detail");
		sql.append(", c.id as id_color ");
		sql.append(", c.ten as name_color ");
		sql.append(", c.code as code_color ");
		sql.append(", c.img ");
		sql.append(", p.date_create ");
		sql.append(", p.date_update ");
		sql.append("FROM ");
		sql.append("products AS p ");
		sql.append("INNER JOIN ");
		sql.append("color_product AS c ");
		sql.append("ON p.id = c.id_product ");
		sql.append("where p.new_product=true ");
		sql.append("GROUP BY p.id, c.id_product ");
		sql.append("ORDER BY RAND() ");
		sql.append("LIMIT 12 ");
		return sql.toString();
	}
	@Override
	public List<products> selectALL() {
		String sql = SqlString();
		  return	jdbcTemplate.query(sql,new Object[] {},new RowMapper<products>(){

			@Override
			public products mapRow(ResultSet rs, int rowNum) throws SQLException {
				products products = new products();
				products.setId_product(rs.getInt("id_product"));
				products.setId_category(rs.getInt("id_category"));
				products.setSize(rs.getString("size"));
				products.setTen(rs.getString("ten"));
				products.setPrice(rs.getDouble("price"));
				products.setSale(rs.getDouble("sale"));
				products.setTitle(rs.getString("title"));
				products.setHighlight(rs.getBoolean("highlight"));
				products.setNew_product(rs.getBoolean("new_product"));
				products.setDetail(rs.getString("detail"));
				products.setId_color(rs.getInt("id_color"));
				products.setName_color(rs.getString("name_color"));
				products.setCode_color(rs.getString("code_color"));
				products.setImg(rs.getString("img"));
				products.setDate_create(rs.getDate("date_create"));
				products.setDate_update(rs.getDate("date_update"));
				return products;
			}
			  
			});
	}

}
