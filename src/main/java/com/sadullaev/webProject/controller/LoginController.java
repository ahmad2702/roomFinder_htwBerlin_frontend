package com.sadullaev.webProject.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {

	/**
	 * Open Login Page
	 * @param model
	 * @return page
	 */
    @RequestMapping(method = RequestMethod.GET)
    public String loginPage(Model model){
    	if(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken ) {
    		return "login";
    	}else {
    		return "redirect:/account";
    	}
    }

}
