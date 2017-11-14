package com.aits.myerp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String homePage() {
		System.out.println("Inside Controller");
		return "admin/adminDashboard";
		
	}
	
	@RequestMapping(value="/adminLogin", method = RequestMethod.GET)
	public String adminLogin() {
		return "admin/adminLogin";
	}
	
	

}