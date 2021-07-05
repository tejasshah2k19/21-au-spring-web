package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.UserBean;
import com.dao.UserDao;
import com.service.EmailService;

@Controller
public class SessionController {

	@Autowired
	UserDao userDao;

	@Autowired
	EmailService emailService;

	@GetMapping("/forgetpassword")
	public String forgetpassword() {

		return "ForgetPassword";
	}

	@PostMapping("/resetpassword")
	public String retrivePassword(UserBean user, Model model) {
		System.out.println(user.getEmail());

		user = userDao.getUserByEmail(user.getEmail());

		if (user == null) {
			model.addAttribute("msg", "Invalid Email");
			return "ForgetPassword";
		} else {
			// send password
			emailService.sendNewPassword(user);
			return "Home";
		}
	}
}
