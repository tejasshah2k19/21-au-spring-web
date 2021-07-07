package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate stmt;

	public void insertUser(UserBean user) {
		stmt.update("insert into users (userid,firstname,email,password) values (?,?,?,?)", user.getUserId(),
				user.getFirstName(), user.getEmail(), user.getPassword());
	}

	public List<UserBean> getAllUsers() {
		return stmt.query("select * from users", new BeanPropertyRowMapper<UserBean>(UserBean.class));
	}

	public UserBean authenticate(String email, String password) {
		try {
			return stmt.queryForObject("select * from users where email = ? and password = ?",
					new Object[] { email, password }, new BeanPropertyRowMapper<UserBean>(UserBean.class));
		} catch (Exception e) {

		}

		return null;
	}

	public boolean checkDuplicateEmail(String email) {

		// tejas@gmail.com-> 2->exception ->0->exception
		List<UserBean> u = stmt.query("select * from users where email = ? ", new Object[] { email },
				new BeanPropertyRowMapper<UserBean>(UserBean.class));
		if (u.size() == 0)
			return false;
		else
			return true;

	}
}
