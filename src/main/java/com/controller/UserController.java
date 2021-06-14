package com.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.UserBean;

@Controller
public class UserController {

	 
	@GetMapping("/signup")
	public String signup(Model model,UserBean user) {
		model.addAttribute("user",user);
		return "Signup"; // jsp
	}

	@PostMapping("/saveuser")
	public String insertUser(@ModelAttribute("user") @Valid UserBean user, BindingResult result, Model model) {

		model.addAttribute("user", user);// request

		// required
		//
		if (result.hasErrors()) { // true
			return "Signup";
		} else {

			System.out.println(user.getFirstName());
			System.out.println(user.getEmail());
			System.out.println(user.getPassword());

			return "Home";// jsp
		}
	}

	public String deleteUser() {
		return "";//
	}
	
	@GetMapping(value="/")
	public String home() {
		System.out.println("-------home----------");
		return "Home";
	}

}
