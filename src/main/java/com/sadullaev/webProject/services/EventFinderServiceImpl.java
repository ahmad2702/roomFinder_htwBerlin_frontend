package com.sadullaev.webProject.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sadullaev.webProject.form.events.Event;
import com.sadullaev.webProject.propertiesLoader.BackendConnection;
import com.google.gson.reflect.TypeToken;

@Service
public class EventFinderServiceImpl implements EventFinderServiceDAO{

	/**
	 * Getter function for url
	 * @return url
	 */
	private static String getUrl() {
		String url = "http://"
				+ BackendConnection.getHost()
				+ ":"
				+ BackendConnection.getPort();
		return url;
	}
	
	/**
	 * Function for send the requests to backend
	 * @param title
	 * @param date
	 * @param lecturer
	 * @param number
	 * @return response
	 */
	public String sendRequestAtBackend(String title, String date, String lecturer, String number) {
		String url = getUrl() + "/events/finder";
		
		String json = "";
		
		URLConnection conn = null;
		try {
			URL urlObj = new URL(url);
		    conn = urlObj.openConnection();
		    conn.setRequestProperty("title", title);
		    conn.setRequestProperty("date", date);
		    conn.setRequestProperty("lecturer", lecturer);
		    conn.setRequestProperty("number", number);
		}catch(IOException e) {
			System.out.println("URL kann nicht geoffnet werden.");
		}
	    
	    try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) 
	    {
	        json = reader.lines().collect(Collectors.joining("\n"));
	    } catch (IOException e) {
			System.out.println("JSON kann nicht abgelesen werden.");
		} 
		
		return json;
	}
	
	/**
	 * Getter function for event from backend
	 * @return event list
	 */
	@Override
	public List<Event> getEvents(String title, String date, String lecturer, String number){
		String json = sendRequestAtBackend(title, date, lecturer, number);
		
	    Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm").create();
		List<Event> events = gson.fromJson(json, new TypeToken<List<Event>>(){}.getType());
		return events;
	}

}
