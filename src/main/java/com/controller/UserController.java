package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.LoginBean;
import com.bean.ResponseBean;
import com.bean.UserBean;
import com.dao.UserDao;

@RestController
public class UserController {

//	@PostMapping("/signup")
//	public signup() {
//		
//	}

	@Autowired
	UserDao userDao;

	@GetMapping("/signup")
	public String signup() {
		// jsp check

		System.out.println("i am inside signup.......");
		return "Signup";
	}

	@PostMapping("/signup")
	public ResponseBean<UserBean> saveUser(UserBean user) {
		ResponseBean<UserBean> rb = new ResponseBean<>();

		if (userDao.checkDuplicateEmail(user.getEmail())) {

			rb.setStatus(-1);
			rb.setMsg("Email Already Taken");
			rb.setData(user);

		} else {

			int userId = (int) (Math.random() * 10000);
			user.setUserId(userId);
			userDao.insertUser(user);

			rb.setStatus(200);
			rb.setMsg("signup successfully done");
			rb.setData(user);
		}
		return rb;
	}

	@GetMapping("/users")
	public List<UserBean> getAllUsers() {
		return userDao.getAllUsers();
	}

	// delete

	// getDataById

	// update

	@PostMapping("/login")
	public ResponseBean<UserBean> login(@Valid LoginBean login, BindingResult result) {

		ResponseBean<UserBean> rb = new ResponseBean<>();
		System.out.println("data---");
		System.out.println(login.getEmail());
		System.out.println(login.getPassword());
		if (result.hasErrors()) {
			rb.setData(null);
			rb.setMsg("Please Fill All Fields");
			rb.setStatus(-1);
		} else {
			UserBean user = userDao.authenticate(login.getEmail(), login.getPassword());
			if (user == null) {
				rb.setData(null);
				rb.setMsg("Invalid Credentials");
				rb.setStatus(-1);
			} else {
				rb.setData(user);
				rb.setMsg("Login done");
				rb.setStatus(200);

			}

		}
		return rb;

	}

}
