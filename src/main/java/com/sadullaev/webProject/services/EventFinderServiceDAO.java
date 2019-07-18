package com.sadullaev.webProject.services;

import java.util.List;

import com.sadullaev.webProject.form.events.Event;

public interface EventFinderServiceDAO {
	
	public List<Event> getEvents(String title, String date, String lecturer, String number);
	
	
}
