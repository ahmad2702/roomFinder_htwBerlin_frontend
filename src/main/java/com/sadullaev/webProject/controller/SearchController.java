package com.sadullaev.webProject.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sadullaev.webProject.form.EventSearchForm;

@Controller
public class SearchController {
	
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	String search(Model model) {
		

		model.addAttribute("eventSearchForm", new EventSearchForm()); 
		
		return "searchpage";
	}
	
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("eventSearchForm") EventSearchForm searchForm, 
      ModelMap model) {
        
		String title = searchForm.getTitle();
		System.out.println(title);
		
		String date = searchForm.getDate();
		System.out.println(date);
		
		String lecturer = searchForm.getLecturer();
		System.out.println(lecturer);
		
		String number = searchForm.getNumber();
		System.out.println(number);
		
		System.out.println("------------------");
		
        return "searchpage";
    }
	
}
