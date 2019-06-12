package com.sadullaev.webProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {
	
	@RequestMapping("/")
	String index() {
		return "home";
	}
	
	@RequestMapping("/welcome")
	String welcome() {
		return "welcomepage";
	}
	
	@RequestMapping("/search")
	String search() {
		return "searchpage";
	}
	
	
}
