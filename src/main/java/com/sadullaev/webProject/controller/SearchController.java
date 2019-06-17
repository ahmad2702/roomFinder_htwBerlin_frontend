package com.sadullaev.webProject.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sadullaev.webProject.form.EventSearchForm;
import com.sadullaev.webProject.model.Event;
import com.sadullaev.webProject.services.EventFinderServiceImpl;

@Controller
public class SearchController {
	
	EventFinderServiceImpl eventFinderService = new EventFinderServiceImpl();
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	String search(Model model) {

		model.addAttribute("eventSearchForm", new EventSearchForm()); 
		
		return "searchpage";
	}
	
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("eventSearchForm") EventSearchForm searchForm, 
      ModelMap model) {
        
		String title = searchForm.getTitle();
		String date = searchForm.getDate();		
		String lecturer = searchForm.getLecturer();		
		String number = searchForm.getNumber();
		
		List<Event> result = eventFinderService.getEvents(title, date, lecturer, number);
		//System.out.println(Arrays.toString(result.toArray()));
		
		model.addAttribute("listEvents", result); 

        return "searchpage";
    }
	
}