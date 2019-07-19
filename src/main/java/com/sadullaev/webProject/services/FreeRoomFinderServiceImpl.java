package com.sadullaev.webProject.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
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
import com.sadullaev.webProject.model.BookingList;
import com.sadullaev.webProject.propertiesLoader.BackendConnection;
import com.sadullaev.webProject.repository.BookingRepository;

@Service
public class FreeRoomFinderServiceImpl implements FreeRoomFinderServiceDAO{
	
	@Autowired
	BookingRepository bookingRepository;
	
	private static String getUrl() {
		String url = "http://"
				+ BackendConnection.getHost()
				+ ":"
				+ BackendConnection.getPort();
		return url;
	}
	
	@Override
	public List<Room> getRooms(String date, String roomName, String time, String number) {
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
				
	    Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm").create();
		List<Room> rooms = gson.fromJson(json, new TypeToken<List<Room>>(){}.getType());
		
		return rooms;
	}

	@Override
	public List<Room> getFreeRoomsForBooking(String date, String roomName, String uhr, String time, String number) {
		List<Room> rooms = getRooms(date, roomName, time, number);

		if(rooms.size() != 0) {
			
			String dateAndUhr = date + " " + uhr;
			LocalDateTime uhrForFilter = LocalDateTime.parse(dateAndUhr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
			/**
			// Filter nach Zeit
			rooms = rooms.stream().filter(x -> x.getBeginTime().getTime()<= Timestamp.valueOf(uhrForFilter).getTime() &&
					x.getEndTime().getTime()>= Timestamp.valueOf(uhrForFilter).getTime()).collect(Collectors.toList());
			*/
			
			//Check alles with bookings
			int timeAsIntAndInMiliseconds = Integer.parseInt(time) * 60000;
			//old rooms.stream().forEach(x -> x.setEndTime(new Timestamp(x.getBeginTime().getTime() + timeAsIntAndInMiliseconds)));

			rooms.stream().forEach(x -> x.setBeginAndEndTime(getZeiten(x, date, uhr, timeAsIntAndInMiliseconds)) );
			
			rooms = rooms.stream().filter(x -> (Timestamp.valueOf(uhrForFilter).getTime()+timeAsIntAndInMiliseconds)<=x.getEndTime().getTime()).collect(Collectors.toList());
		}
		
		return rooms;
	}
	
	private Timestamp[] getZeiten(Room room, String date, String uhr, int time) {
		String dateAndUhr = date + " " + uhr;
		LocalDateTime uhrForFilter = LocalDateTime.parse(dateAndUhr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		
		Date dateAsDate = Date.valueOf(date);
		
		Timestamp[] result = new Timestamp[2];
		
		
		Timestamp beginTime = null;
		Timestamp endTime = null;
		
		if(Timestamp.valueOf(uhrForFilter).getTime()>=room.getBeginTime().getTime() && (Timestamp.valueOf(uhrForFilter).getTime()+time) <= room.getEndTime().getTime()) {
			beginTime = Timestamp.valueOf(uhrForFilter);
		}else {
			beginTime = room.getBeginTime();
		}
		
		endTime = new Timestamp(beginTime.getTime() + time);
		
		
		
		List<BookingList> b = (List<BookingList>) bookingRepository.findAllByDateAndRoom(dateAsDate, room.getRoomName());
		
		result[0] = beginTime;
		result[1] = endTime;
		
		return result;
	}
	
	
	

}
