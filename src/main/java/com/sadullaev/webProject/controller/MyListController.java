package com.sadullaev.webProject.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sadullaev.webProject.form.freeRooms.Room;
import com.sadullaev.webProject.model.BookingList;
import com.sadullaev.webProject.model.User;
import com.sadullaev.webProject.repository.BookingRepository;

@Controller
public class MyListController {
	
	@Autowired
	BookingRepository bookingRepository;
	
	@RequestMapping("/myList")
	String liste(ModelMap model) {
		
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		model.addAttribute("booking_list", user.getBookingList());
		model.addAttribute("bookRoomForm", new Room()); 
		
		return "my_list";
	}
	
	
	
	
	
	//-----------------------------Bearbeitung START------------------------------------------------------
		@RequestMapping(value = "/myList/edit", method = RequestMethod.POST)
	    public String save(@Valid @ModelAttribute("bookRoomForm") Room room,
	    		ModelMap model) {
			
			int id = room.getId();
			System.out.println(id);
			
			BookingList booking = bookingRepository.findById(id);
			System.out.println(booking);
			
			return "redirect:/myList";
		}
		
		
		
		//-------------------------------BELEGUNG END----------------------------------------------------
		
	
}
