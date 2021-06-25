package com.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.bean.ProductBean;

@Repository
public class ProductDao {

	@Autowired
	JdbcTemplate stmt;//

	// insert update delete --> update()

	public int insertProduct(final ProductBean product) {
		int productId = 0;

		GeneratedKeyHolder holder = new GeneratedKeyHolder();

		stmt.update(new PreparedStatementCreator() {

			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

				PreparedStatement pstmt = con.prepareStatement("insert into product (productname,price,imgpath,categoryid) values (?,?,?,?)",
						java.sql.Statement.RETURN_GENERATED_KEYS);

				pstmt.setString(1, product.getProductName());
				pstmt.setInt(2, product.getPrice());
				pstmt.setString(3, "");
				pstmt.setInt(4, product.getCategoryId());
				
				// TODO Auto-generated method stub
				return pstmt;
			}
		}, holder);

		productId = (Integer)holder.getKeys().get("productId");
		System.out.println("product inserted..... with => "+productId);
		return productId;
		//
	}

	public List<ProductBean> getAllProducts() {
		// query("query","mapper") --> return 0 or n

		List<ProductBean> products = stmt.query("select * from product,category where product.categoryid = category.categoryid",
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
		stmt.update("update product set productname = ? , price = ? where productid = ?", product.getProductName(),
				product.getPrice(), product.getProductId());
	}

	public void addImage(String dbPath, int productId) {
		stmt.update("update product set imgPath = ? where productId = ? ", dbPath, productId);
	}

}
