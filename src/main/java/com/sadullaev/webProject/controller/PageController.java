package com.sadullaev.webProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	@RequestMapping("/")
	String index() {
		return "home";
	}
	
	@RequestMapping("/search")
	String search() {
		return "searchpage";
	}
	

	
	
}
