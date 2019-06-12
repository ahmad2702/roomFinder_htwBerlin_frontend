package com.sadullaev.webProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {
	
	@RequestMapping("/")
	String home() {
		return "home";
	}
	
	@RequestMapping("/welcome")
	String welcome() {
		return "welcomepage";
	}
	
	
	
	
}
