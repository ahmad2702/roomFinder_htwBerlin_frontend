package com.sadullaev.webProject.services;

import java.util.List;

import com.sadullaev.webProject.model.Room;

public interface FreeRoomFinderServiceDAO {
	
	public List<Room> getRooms(String date, String roomName, String uhr, String time, String number);
	
}
