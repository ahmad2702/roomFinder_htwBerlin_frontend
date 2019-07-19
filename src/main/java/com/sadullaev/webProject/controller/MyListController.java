package com.sadullaev.webProject.controller;

import javax.validation.Valid;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sadullaev.webProject.form.freeRooms.BookRoom;
import com.sadullaev.webProject.model.User;

@Controller
public class MyListController {
	
	@RequestMapping("/myList")
	String liste(ModelMap model) {
		
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		model.addAttribute("booking_list", user.getBookingList());
		model.addAttribute("bookRoomForm", new BookRoom()); 
		
		return "my_list";
	}
	
	
	
	
	
	//-----------------------------Bearbeitung START------------------------------------------------------
		@RequestMapping(value = "/myList/edit", method = RequestMethod.POST)
	    public String save(@Valid @ModelAttribute("bookRoomForm") BookRoom bookRoom,
	    		ModelMap model) {
			
			String id = bookRoom.getId();
			System.out.println(id);

			
			
			
			return "redirect:/myList";
		}
		
		
		
		//-------------------------------BELEGUNG END----------------------------------------------------
		
	
}
