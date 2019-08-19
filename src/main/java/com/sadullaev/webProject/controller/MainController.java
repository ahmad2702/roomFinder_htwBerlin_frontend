package com.sadullaev.webProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class MainController {
	
	/**
	 * Open Home Page
	 * @return page
	 */
	@RequestMapping(method = RequestMethod.GET)
	String index() {
		return "home";
	}

}
