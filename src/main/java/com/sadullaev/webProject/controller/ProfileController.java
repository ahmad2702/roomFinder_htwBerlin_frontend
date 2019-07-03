package com.sadullaev.webProject.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sadullaev.webProject.model.User;


@Controller
public class ProfileController {
	
	@RequestMapping("/account")
	String account(ModelMap model) {
		
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		model.addAttribute("user", user);
		return "profile";
	}
	
	
}
