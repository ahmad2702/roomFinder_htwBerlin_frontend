package com.sadullaev.webProject.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sadullaev.webProject.form.events.Event;
import com.sadullaev.webProject.form.events.EventSearchForm;
import com.sadullaev.webProject.form.freeRooms.FreeRoomSearchForm;
import com.sadullaev.webProject.services.EventFinderServiceDAO;

@Controller
public class EventSearchController {
	
	@Autowired
	EventFinderServiceDAO eventFinderService;
		
	
	
	@RequestMapping(value="/search/event", method=RequestMethod.GET)
	String search(Model model) {

		model.addAttribute("eventSearchForm", new EventSearchForm()); 
		
		boolean startSearch = true;
		model.addAttribute("startSearch", startSearch); 
		
		return "eventSearchPage";
	}
	
	
	@RequestMapping(value = "/search/event", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("eventSearchForm") EventSearchForm searchForm, 
    		@Valid @ModelAttribute("freeRoomSearchForm") FreeRoomSearchForm freeRoomSearchForm,
    		ModelMap model) {
        
		String title = searchForm.getTitle();
		String date = searchForm.getDate();		
		String lecturer = searchForm.getLecturer();		
		String number = searchForm.getNumber();
		
		List<Event> result = eventFinderService.getEvents(title, date, lecturer, number);
		
		model.addAttribute("listEvents", result); 
		
		boolean startSearch = false;
		model.addAttribute("startSearch", startSearch); 

        return "eventSearchPage";
    }
	
}
