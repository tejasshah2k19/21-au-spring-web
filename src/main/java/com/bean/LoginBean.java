package com.bean;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LoginBean {

	@NotNull(message = "Email is Required")
	String email;

	@NotBlank(message = "Password is Required")
	String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
