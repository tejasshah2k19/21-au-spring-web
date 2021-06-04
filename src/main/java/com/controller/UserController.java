package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

	@GetMapping("/signup")
	public String signup() {
		return "Signup"; // jsp
	}

	@PostMapping("/saveuser")
	public String insertUser() {
		return "Home";// jsp
	}

	public String deleteUser() {
		return "";//
	}

}
