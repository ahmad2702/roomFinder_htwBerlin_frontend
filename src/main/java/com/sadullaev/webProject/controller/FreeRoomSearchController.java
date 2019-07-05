package com.sadullaev.webProject.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sadullaev.webProject.form.FreeRoomSearchForm;
import com.sadullaev.webProject.model.Room;
import com.sadullaev.webProject.services.FreeRoomFinderServiceDAO;

@Controller
public class FreeRoomSearchController {
	
	@Autowired
	FreeRoomFinderServiceDAO freeRoomFinderService;
	
	
	@RequestMapping(value="/search/freeRoom", method=RequestMethod.GET)
	String search(Model model) {

		model.addAttribute("freeRoomSearchForm", new FreeRoomSearchForm()); 
		
		String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		model.addAttribute("currentDate", currentDate); 
		
		boolean startSearch = true;
		model.addAttribute("startSearch", startSearch); 
		
		return "freeRoomSearchPage";
	}
	
	@RequestMapping(value = "/search/freeRoom", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("freeRoomSearchForm") FreeRoomSearchForm freeRoomSearchForm,
    		ModelMap model) {
        
		String date = freeRoomSearchForm.getDate();
		String roomName = freeRoomSearchForm.getRoom();		
		String time = freeRoomSearchForm.getTime();		
		String number = freeRoomSearchForm.getNumber();
		
		List<Room> rooms = freeRoomFinderService.getRooms(date, roomName, time, number);
		
		model.addAttribute("rooms", rooms); 
		
		boolean startSearch = false;
		model.addAttribute("startSearch", startSearch); 

        return "freeRoomSearchPage";
    }
	
}
