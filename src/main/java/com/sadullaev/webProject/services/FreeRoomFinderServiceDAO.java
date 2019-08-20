package com.sadullaev.webProject.services;

import java.util.List;

import com.sadullaev.webProject.form.freeRooms.Room;

public interface FreeRoomFinderServiceDAO {
	
	/**
	 * Function to find free rooms into backend
	 * @param date
	 * @param roomName
	 * @param time
	 * @param number
	 * @return rooms
	 */
	public List<Room> getRooms(String date, String roomName, String time, String number);
	
	/**
	 * Optimized function to generate free rooms for booking
	 * @param date
	 * @param roomName
	 * @param uhr
	 * @param time
	 * @param number
	 * @return rooms
	 */
	public List<Room> getFreeRoomsForBooking(String date, String roomName, String uhr, String time, String number);
	
}
