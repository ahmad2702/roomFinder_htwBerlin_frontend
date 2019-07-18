package com.sadullaev.webProject.form.freeRooms;

import java.sql.Date;
import java.sql.Timestamp;

public class Room {
	
	private Date date;
	private String roomName;
	private Timestamp beginTime;
	private Timestamp endTime;
	private int time;
	
	public Room(Date date, String roomName, Timestamp beginTime, Timestamp endTime, int time) {
		this.date = date;
		this.roomName = roomName;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.time = time;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public Timestamp getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Timestamp beginTime) {
		this.beginTime = beginTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Room [date=" + date + ", roomName=" + roomName + ", beginTime=" + beginTime + ", endTime=" + endTime
				+ ", time=" + time + "]";
	}
	
	
	
	
	
	
}
