package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate stmt;

	public UserBean getUserByEmail(String email) {
		UserBean user = null;

		try {
			user = stmt.queryForObject("select * from users where email = ?", new Object[] { email },
					new BeanPropertyRowMapper<UserBean>(UserBean.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}
}
