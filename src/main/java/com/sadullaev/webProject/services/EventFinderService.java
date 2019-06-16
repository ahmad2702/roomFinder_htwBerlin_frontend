package com.sadullaev.webProject.services;

import java.util.List;

import com.sadullaev.webProject.model.Event;

public interface EventFinderService {
	
	public List<Event> getEvents(String title, String date, String lecturer, String number);
	
	
}
