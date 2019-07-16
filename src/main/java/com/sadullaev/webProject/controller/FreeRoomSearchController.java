package com.sadullaev.webProject.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
	
	
	List<String> getTimeFormatForDauer(int von, int bis) {
		List<String> minuten = new ArrayList<String>();
		minuten.add("00");
		minuten.add("15");
		minuten.add("30");
		minuten.add("45");
		
		List<String> result = new ArrayList<String>();
		for(int hour = von; hour < bis; hour++) {
			for(int min = 0; min < minuten.size(); min++) {
				String dauer = hour + ":" + minuten.get(min);
				if(!dauer.equals("0:00")) {
					result.add(dauer);
				}
			}
		}

		return result;
	}
	
	List<String> getTimeFormatForZeituhr(int von, int bis) {
		List<String> minuten = new ArrayList<String>();
		minuten.add("00");
		minuten.add("15");
		minuten.add("30");
		minuten.add("45");
		
		List<String> result = new ArrayList<String>();
		for(int hour = von; hour < bis; hour++) {
			for(int min = 0; min < minuten.size(); min++) {
				
				String zeit = "";
				if(hour < 10) {
					zeit = 0 + "" + hour + ":" + minuten.get(min);
				}else {
					zeit = hour + ":" + minuten.get(min);
				}

				if(!zeit.equals("00:00")) {
					result.add(zeit);
				}
				
			}
		}

		return result;
	}

	
	@RequestMapping(value="/search/freeRoom", method=RequestMethod.GET)
	String search(Model model) {

		model.addAttribute("freeRoomSearchForm", new FreeRoomSearchForm()); 
		
		String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		model.addAttribute("currentDate", currentDate); 

		model.addAttribute("dauer", getTimeFormatForDauer(0, 10)); 
		model.addAttribute("zeituhr", getTimeFormatForZeituhr(7, 20)); 
		
		boolean startSearch = true;
		model.addAttribute("startSearch", startSearch); 
		
		return "freeRoomSearchPage";
	}
	
	@RequestMapping(value = "/search/freeRoom", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("freeRoomSearchForm") FreeRoomSearchForm freeRoomSearchForm,
    		ModelMap model) {
        
		String date = freeRoomSearchForm.getDate();
		
		String uhr = freeRoomSearchForm.getUhr();	
		System.out.println(uhr);
		
		String dauer = convertStringToDauer(freeRoomSearchForm.getDauer());	
		System.out.println(dauer);

		String roomName = freeRoomSearchForm.getRoom();		
		String number = freeRoomSearchForm.getNumber();
		
		
			
		
		// Die Liste wird hier von Backend abgefragt
		List<Room> rooms = freeRoomFinderService.getFreeRoomsForBooking(date, roomName, uhr, dauer, number);
		
		
		model.addAttribute("rooms", rooms); 
		
		boolean startSearch = false;
		model.addAttribute("startSearch", startSearch); 
		
		model.addAttribute("dauer", getTimeFormatForDauer(0, 10)); 
		model.addAttribute("zeituhr", getTimeFormatForZeituhr(7, 20)); 

        return "freeRoomSearchPage";
    }
	
	String convertStringToDauer(String dauer) {
		String[] data = dauer.split(":");
		
		int hour = Integer.parseInt(data[0]) * 60;
		int min = Integer.parseInt(data[1]);
		int sum = hour + min;
		
		return "" + sum;
	}
	
	
	
}
