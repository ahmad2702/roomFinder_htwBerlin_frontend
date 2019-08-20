package com.sadullaev.webProject.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.sadullaev.webProject.form.freeRooms.Room;
import com.sadullaev.webProject.propertiesLoader.BackendConnection;
import com.sadullaev.webProject.repository.BookingRepository;

@Service
public class FreeRoomFinderServiceImpl implements FreeRoomFinderServiceDAO{
	
	@Autowired
	BookingRepository bookingRepository;
	
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
	 * @param date
	 * @param roomName
	 * @param time
	 * @param number
	 * @return response
	 */
	public String sendRequestAtBackend(String date, String roomName, String time, String number) {
		String url = getUrl() + "/rooms/free";
		
		String json = "";
		
		URLConnection conn = null;
		try {
			URL urlObj = new URL(url);
		    conn = urlObj.openConnection();
		    conn.setRequestProperty("date", date);
		    conn.setRequestProperty("room", roomName);
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
	    
	    return json;
	}
	
	/**
	 * Getter function for room list from backend
	 * @return room list
	 */
	@Override
	public List<Room> getRooms(String date, String roomName, String time, String number) {
		String json = sendRequestAtBackend(date, roomName, time, number);
				
	    Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm").create();
		List<Room> rooms = gson.fromJson(json, new TypeToken<List<Room>>(){}.getType());
		
		return rooms;
	}

	/**
	 * Optimized for booking getter function for free rooms 
	 * @return room list
	 */
	@Override
	public List<Room> getFreeRoomsForBooking(String date, String roomName, String uhr, String time, String number) {
		List<Room> rooms = getRooms(date, roomName, time, number);

		if(rooms.size() != 0) {
			
			//Time optimizing
			String dateAndUhr = date + " " + uhr;
			LocalDateTime uhrForFilter = LocalDateTime.parse(dateAndUhr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

			int timeAsIntAndInMiliseconds = Integer.parseInt(time) * 60000;
			rooms.stream().forEach(x -> x.setBeginAndEndTime(getAngepassteZeiten(x, date, Timestamp.valueOf(uhrForFilter), timeAsIntAndInMiliseconds)) );
			rooms = rooms.stream().filter(x -> (Timestamp.valueOf(uhrForFilter).getTime()+timeAsIntAndInMiliseconds)<=x.getEndTime().getTime()).collect(Collectors.toList());
		}
		
		return rooms;
	}
	
	/**
	 * Function for time optimizing
	 * @param room
	 * @param date
	 * @param uhr
	 * @param time
	 * @return time
	 */
	public Timestamp[] getAngepassteZeiten(Room room, String date, Timestamp uhr, int time) {
		Timestamp[] result = new Timestamp[2];

		Timestamp beginTime = null;
		Timestamp endTime = null;
		
		if(uhr.getTime()>=room.getBeginTime().getTime() && (uhr.getTime()+time) <= room.getEndTime().getTime()) {
			beginTime = uhr;
		}else {
			beginTime = room.getBeginTime();
		}
		
		endTime = new Timestamp(beginTime.getTime() + time);

		result[0] = beginTime;
		result[1] = endTime;
		
		return result;
	}

}
