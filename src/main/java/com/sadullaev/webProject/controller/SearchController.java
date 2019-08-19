package com.sadullaev.webProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SearchController {
	
	/**
	 * OPen Main Search Page
	 * @return page
	 */
	@RequestMapping("/search")
	String search() {
		return "searchpage";
	}
	
}
