package com.sadullaev.webProject.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sadullaev.webProject.form.addUserToRoom.AddUserToBooking;
import com.sadullaev.webProject.form.freeRooms.Room;
import com.sadullaev.webProject.model.BookingList;
import com.sadullaev.webProject.model.User;
import com.sadullaev.webProject.repository.BookingRepository;
import com.sadullaev.webProject.repository.UsersRepository;

@Controller
public class MyListController {
	
	@Autowired
	UsersRepository userRepository;
	
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
			System.out.println("Edit booking by ID: " + id);
			
			BookingList booking = bookingRepository.findById(id);
			model.addAttribute("booking", booking); 
			model.addAttribute("addUser", new AddUserToBooking());
			
			return "edit_booking";
		}
		
		//-------------------------------BELEGUNG END----------------------------------------------------
		
		@RequestMapping(value = "/myList/edit/addUser", method = RequestMethod.POST)
	    public String addUser(@Valid @ModelAttribute("addUser") AddUserToBooking addUserToBooking,
	    		ModelMap model) {
			
			String username = addUserToBooking.getUsername();
			System.out.println("Username: " + username);
			User newUser = userRepository.findByUsername(username); 
			
			
			int id = addUserToBooking.getBookingId();
			BookingList booking = bookingRepository.findById(id);
			
			if(newUser != null) {
				booking.addUser(newUser);
				bookingRepository.save(booking);
			}


			
			
			model.addAttribute("booking", booking); 
			model.addAttribute("addUser", new AddUserToBooking());
			
			return "edit_booking";
		}
		
}
