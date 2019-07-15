package com.sadullaev.webProject.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.sadullaev.webProject.model.Room;
import com.sadullaev.webProject.propertiesLoader.BackendConnection;

@Service
public class FreeRoomFinderServiceImpl implements FreeRoomFinderServiceDAO{

	private static String getUrl() {
		String url = "http://"
				+ BackendConnection.getHost()
				+ ":"
				+ BackendConnection.getPort();
		return url;
	}
	
	@Override
	public List<Room> getRooms(String date, String roomName, String uhr, String time, String number) {
		String url = getUrl() + "/rooms/free";
		
		String json = "";
		
		URLConnection conn = null;
		try {
			URL urlObj = new URL(url);
		    conn = urlObj.openConnection();
		    conn.setRequestProperty("date", date);
		    conn.setRequestProperty("room", roomName);
		    conn.setRequestProperty("uhr", uhr);
		    conn.setRequestProperty("time", time);
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
				
	    Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm").create();
		List<Room> rooms = gson.fromJson(json, new TypeToken<List<Room>>(){}.getType());
		
		return rooms;
	}
	
	private static void filterAndOptimizeRooms(List<Room> rooms, Timestamp startTime, int dauer) {
		
		
		
		rooms.stream().filter(room -> startTime.getTime() > room.getBeginTime().getTime() && startTime.getTime()+dauer < room.getBeginTime().getTime());
		
		
		
		
	}
	

}
