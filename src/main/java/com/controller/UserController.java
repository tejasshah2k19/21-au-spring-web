package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public UserBean saveUser(UserBean user) {
		int userId = (int) (Math.random() * 10000);
		user.setUserId(userId);
		userDao.insertUser(user);
		return user;
	}
	
	
	@GetMapping("/users")
	public List<UserBean> getAllUsers(){
		return userDao.getAllUsers();
	}
	
	
	//delete 
	
	//getDataById 
	
	//update 

}
