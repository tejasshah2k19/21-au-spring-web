package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.ProductBean;

@Repository
public class ProductDao {

	@Autowired
	JdbcTemplate stmt;//

	public void insertProduct(ProductBean product) {

		stmt.update("insert into product (productname,price) values (?,?)", product.getProductName(),
				product.getPrice());
	}

	public List<ProductBean> getAllProducts() {

		List<ProductBean> products = stmt.query("select * from product",
				new BeanPropertyRowMapper<ProductBean>(ProductBean.class));
		return products;
	}
	//

	public void deleteProductById(int productId) {
		stmt.update("delete from product where productid = ?",productId);
		
	}
}
