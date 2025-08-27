package com.SpringSecurity.SpringSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Securitycontroller {

	@RequestMapping("/test")
	public String getMessage() {
		return "You are Authenticated using the Database";
	}
}
