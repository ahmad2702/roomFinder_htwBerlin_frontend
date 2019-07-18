package com.sadullaev.webProject.services;

import java.util.List;

import com.sadullaev.webProject.form.freeRooms.Room;

public interface FreeRoomFinderServiceDAO {
	
	// sucht die freie Raueme aus Backend
	public List<Room> getRooms(String date, String roomName, String uhr, String time, String number);
	
	// optimisiert fur die Belegung in Frontend
	public List<Room> getFreeRoomsForBooking(String date, String roomName, String uhr, String time, String number);
	
}
