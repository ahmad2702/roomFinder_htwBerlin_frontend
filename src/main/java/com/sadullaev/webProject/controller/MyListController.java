package com.sadullaev.webProject.controller;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sadullaev.webProject.form.editBooking.UserOperation;
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
		
		/**
		 * Open Booking list page
		 * @param model
		 * @return page
		 */
		@RequestMapping("/myList")
		String liste(ModelMap model) {
			
			User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			user = userRepository.findById(user.getId()).get();
			
			model.addAttribute("booking_list", user.getBookingList());
			model.addAttribute("bookRoomForm", new Room()); 
			
			return "my_list";
		}
		
		
		
		
		//-----------------------------Bearbeitung START------------------------------------------------------
		@RequestMapping("/myList/edit")
		String editPageRedirect(@ModelAttribute("booking") BookingList booking,
				ModelMap model) {
			
			if(booking.getRoom() != null) {
				
				User currentUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				
				model.addAttribute("currentUser", currentUser); 
				model.addAttribute("booking", booking); 
				model.addAttribute("addUser", new UserOperation());
				model.addAttribute("removeUser", new UserOperation());
				return "edit_booking";
				
			}else {
				return "redirect:/myList";
			}
			
			
		}

		@RequestMapping(value = "/myList/edit", method = RequestMethod.POST)
	    public String openEditPage(@Valid @ModelAttribute("bookRoomForm") Room room,
	    		ModelMap model) {
			
			int id = room.getId();
			BookingList booking = bookingRepository.findById(id).get();
			
			User currentUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
			model.addAttribute("currentUser", currentUser); 
			model.addAttribute("booking", booking); 
			model.addAttribute("addUser", new UserOperation());
			model.addAttribute("removeUser", new UserOperation());
			
			return "edit_booking";
		}
		//-------------------------------Bearbeitung END----------------------------------------------------

		
		
		
		//-----------------------------Add User START------------------------------------------------------
		@RequestMapping("/myList/edit/addUser")
		String addUserRedirect(ModelMap model) {
			return "redirect:/myList";
		}
		
		@RequestMapping(value = "/myList/edit/addUser", method = RequestMethod.POST)
	    public String addUser(@Valid @ModelAttribute("addUser") UserOperation addUserToBooking,
	    		final RedirectAttributes redirectAttributes,
	    		ModelMap model) {
			
			String username = addUserToBooking.getUsername();
			User newUser = userRepository.findByUsername(username); 
			
			
			int id = addUserToBooking.getBookingId();
			BookingList booking = bookingRepository.findById(id).get();
			
			
			if(newUser != null) {
				if(booking.getUsers().stream().filter(x -> x.getUsername().equals(username)).findFirst().orElse(null) == null) {
					booking.addUser(newUser);
					bookingRepository.save(booking);
					//booking = bookingRepository.findById(id).get();
					System.out.println("Refreshed booking Edit");
				}
			}else {
				// user existiert nicht
			}

			
			redirectAttributes.addFlashAttribute("booking", booking);
			
			return "redirect:/myList/edit";
		}
		//-----------------------------Add User END------------------------------------------------------
		

		
		
		//-----------------------------Remove User START------------------------------------------------------
		@RequestMapping("/myList/edit/removeUser")
		String removeUserRedirect(ModelMap model) {
			return "redirect:/myList";
		}
		
		@RequestMapping(value = "/myList/edit/removeUser", method = RequestMethod.POST)
	    public String removeUser(@Valid @ModelAttribute("removeUser") UserOperation removeUserFromBooking,
	    		final RedirectAttributes redirectAttributes,
	    		ModelMap model) {
			
			int userId = removeUserFromBooking.getUserId();
			int bookingId = removeUserFromBooking.getBookingId();
			
			BookingList booking = bookingRepository.findById(bookingId).get();
			
			if(booking.getUsers().size() == 1 && booking.getUsers().get(0).getId()==userId) {
				bookingRepository.delete(booking);
				return "redirect:/myList";
			}else {
				booking.setUsers(booking.getUsers().stream().filter(x -> x.getId() != userId).collect(Collectors.toList()));
				bookingRepository.save(booking);
			}

			User currentUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
			if(currentUser.getId() == userId) {
				return "redirect:/myList";
			}
			
			redirectAttributes.addFlashAttribute("booking", booking);
			
			return "redirect:/myList/edit";
		}		
		//-----------------------------Remove User END------------------------------------------------------
		
}
