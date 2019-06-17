package com.sadullaev.webProject.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sadullaev.webProject.form.FreeRoomSearchForm;

@Controller
public class FreeRoomSearchController {
	
	@RequestMapping(value="/search/freeRoom", method=RequestMethod.GET)
	String search(Model model) {

		model.addAttribute("freeRoomSearchForm", new FreeRoomSearchForm()); 
		
		return "freeRoomSearchPage";
	}
	
	@RequestMapping(value = "/search/freeRoom", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("freeRoomSearchForm") FreeRoomSearchForm freeRoomSearchForm,
    		ModelMap model) {
        
		String date = freeRoomSearchForm.getDate();
		String room = freeRoomSearchForm.getRoom();		
		String time = freeRoomSearchForm.getTime();		
		String number = freeRoomSearchForm.getNumber();
		
		

        return "freeRoomSearchPage";
    }
	
}
