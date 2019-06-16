package com.sadullaev.webProject.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sadullaev.webProject.model.Event;
import com.sadullaev.webProject.propertiesLoader.BackendConnection;
import com.google.gson.reflect.TypeToken;

public class EventFinderServiceImpl implements EventFinderService{

	private static String getUrl() {
		String url = "http://"
				+ BackendConnection.getHost()
				+ ":"
				+ BackendConnection.getPort();
		
		return url;
	}
	
	@Override
	public List<Event> getEvents(String title, String date, String lecturer, String number){
		/**
		String url = getUrl() + "/events/" + number;
		
		String json = "";
		
		URLConnection conn = null;
		try {
			URL urlObj = new URL(url);
		    conn = urlObj.openConnection();
		}catch(IOException e) {
			System.out.println("URL kann nicht geoffnet werden.");
		}
	    
	    
	    try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) 
	    {
	        json = reader.lines().collect(Collectors.joining("\n"));
	    } catch (IOException e) {
			System.out.println("JSON kann nicht abgelesen werden.");
		} 
		
		System.out.println(json);
		
	    Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm").create();
		List<Event> events = gson.fromJson(json, new TypeToken<List<Event>>(){}.getType());
		//System.out.println("Size: " + events.size());
		return events;
		*/
		return test();
	}
	
	private List<Event> test(){
		List<Event> result = new ArrayList<>();
		
		Event event1 = new Event(new Date(1), new Timestamp(44), new Timestamp(49), "Test1", 1, "Room 1", "L 1");
		Event event2 = new Event(new Date(2), new Timestamp(44), new Timestamp(49), "Test2", 2, "Room 2", "L 2");
		
		result.add(event1);
		result.add(event2);
		
		return result;
	}

	
}
