package com.sadullaev.webProject.services;

import java.util.List;

import com.sadullaev.webProject.form.events.Event;

public interface EventFinderServiceDAO {
	
	/**
	 * Function for get all events
	 * @param title
	 * @param date
	 * @param lecturer
	 * @param number
	 * @return event list
	 */
	public List<Event> getEvents(String title, String date, String lecturer, String number);

}
