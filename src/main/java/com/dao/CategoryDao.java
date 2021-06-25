package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.CategoryBean;

@Repository
public class CategoryDao {

	@Autowired
	JdbcTemplate stmt;

	public List getAllCategories() {
		return stmt.query("select * from category", new BeanPropertyRowMapper<CategoryBean>(CategoryBean.class));
	}
}
