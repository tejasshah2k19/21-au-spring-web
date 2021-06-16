package com.dao;

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

	// insert update delete --> update()

	public void insertProduct(ProductBean product) {

		stmt.update("insert into product (productname,price) values (?,?)", product.getProductName(),
				product.getPrice());
	}

	public List<ProductBean> getAllProducts() {
		// query("query","mapper") --> return 0 or n

		List<ProductBean> products = stmt.query("select * from product",
				new BeanPropertyRowMapper<ProductBean>(ProductBean.class));
		return products;
	}
	//

	public void deleteProductById(int productId) {
		stmt.update("delete from product where productid = ?", productId);

	}

	public ProductBean getProductById(int productId) {
		// queryForObject must return single record
		ProductBean product = stmt.queryForObject("select * from product where productid = " + productId,
				new BeanPropertyRowMapper<ProductBean>(ProductBean.class));
		return product;
	}

	public void updateProduct(ProductBean product) {
		stmt.update("update product set productname = ? , price = ? where productid = ?",product.getProductName(),product.getPrice(),product.getProductId());
	}
	
	
	
}
