package com.sadullaev.webProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {
	
	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Greetings from Java Tutorial Network";
	}
	
	@RequestMapping("/welcome")
	String welcome() {
		return "welcomepage";
	}
	
	
	
	
}
