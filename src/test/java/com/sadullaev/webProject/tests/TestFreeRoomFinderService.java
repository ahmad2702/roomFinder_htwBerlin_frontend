package com.sadullaev.webProject.tests;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import com.sadullaev.webProject.form.freeRooms.Room;
import com.sadullaev.webProject.services.FreeRoomFinderServiceImpl;

public class TestFreeRoomFinderService {
	
	@Test
	public void getRoomsTest() {
		String erwartet = "[Room [date=2019-07-11, roomName=WH Gebäude C 624, beginTime=2019-07-11 07:00:00.0, "
				+ "endTime=2019-07-11 09:45:00.0, time=165], Room [date=2019-07-11, roomName=WH Gebäude C 624, "
				+ "beginTime=2019-07-11 11:15:00.0, endTime=2019-07-11 22:00:00.0, time=645]]";
		
		String mockJson = "[{\"date\":\"2019-07-11 00:00\",\"roomName\":\"WH Gebäude C 624\",\""
				+ "beginTime\":\"2019-07-11 07:00\",\"endTime\":\"2019-07-11 09:45\",\"time\":"
				+ "165},{\"date\":\"2019-07-11 00:00\",\"roomName\":\"WH Gebäude C 624\",\""
				+ "beginTime\":\"2019-07-11 11:15\",\"endTime\":\"2019-07-11 22:00\",\"time\":645}]";
		
		FreeRoomFinderServiceImpl freeRoomFinderService = Mockito.spy(FreeRoomFinderServiceImpl.class);
		doReturn(mockJson).when(freeRoomFinderService).sendRequestAtBackend("2019-07-11", "C 624", "30", "10");
		
		List<Room> result = freeRoomFinderService.getRooms("2019-07-11", "C 624", "30", "10");

		assertTrue(result.toString().equals(erwartet));
	}
	
	@Test
	public void getFreeRoomsForBookingTest() {
		String erwartet = "[Room [date=2019-07-11, roomName=WH Gebäude C 624, beginTime=2019-07-11 11:15:00.0, "
				+ "endTime=2019-07-11 11:45:00.0, time=645]]";
		
		String mockJson = "[{\"date\":\"2019-07-11 00:00\",\"roomName\":\"WH Gebäude C 624\",\""
				+ "beginTime\":\"2019-07-11 07:00\",\"endTime\":\"2019-07-11 09:45\",\"time\":"
				+ "165},{\"date\":\"2019-07-11 00:00\",\"roomName\":\"WH Gebäude C 624\",\""
				+ "beginTime\":\"2019-07-11 11:15\",\"endTime\":\"2019-07-11 22:00\",\"time\":645}]";
		
		FreeRoomFinderServiceImpl freeRoomFinderService = Mockito.spy(FreeRoomFinderServiceImpl.class);
		doReturn(mockJson).when(freeRoomFinderService).sendRequestAtBackend("2019-07-11", "C 624", "30", "10");
		
		List<Room> result = freeRoomFinderService.getFreeRoomsForBooking("2019-07-11", "C 624", "09:45", "30", "10");

		assertTrue(result.toString().equals(erwartet));
	}
	
	@Test
	public void getAngepassteZeitenTest() {
		String erwartet = "[2019-07-11 09:45:00.0, 2019-07-11 10:15:00.0]";
		
		FreeRoomFinderServiceImpl freeRoomFinderService = new FreeRoomFinderServiceImpl();
		Room room = new Room();
		room.setTime(11);
		
		String dateAndUhr = "2019-07-11 07:00";
		LocalDateTime uhrForFilter = LocalDateTime.parse(dateAndUhr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		room.setBeginTime(Timestamp.valueOf(uhrForFilter));
		
		dateAndUhr = "2019-07-11 18:00";
		uhrForFilter = LocalDateTime.parse(dateAndUhr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		room.setEndTime(Timestamp.valueOf(uhrForFilter));
		
		dateAndUhr = "2019-07-11 09:45";
		uhrForFilter = LocalDateTime.parse(dateAndUhr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		
		Timestamp[] result = freeRoomFinderService.getAngepassteZeiten(room, "2019-07-11", Timestamp.valueOf(uhrForFilter), 30*60000);

		assertTrue(Arrays.toString(result).equals(erwartet));
	}
	
}
