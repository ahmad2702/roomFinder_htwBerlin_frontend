package com.sadullaev.webProject.form.freeRooms;

import java.sql.Date;
import java.sql.Timestamp;

public class Room {
	
	/**
	 * Instance variables
	 */
	
	private int id;
	private Date date;
	private String roomName;
	private Timestamp beginTime;
	private Timestamp endTime;
	private int time;
	
	/**
	 * Constructor
	 * @param date
	 * @param roomName
	 * @param beginTime
	 * @param endTime
	 * @param time
	 */
	public Room(Date date, String roomName, Timestamp beginTime, Timestamp endTime, int time) {
		this.date = date;
		this.roomName = roomName;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.time = time;
	}
	
	/**
	 * Constructor
	 */
	public Room() {
		
	}

	/**
	 * Getter function for id
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter function for id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter function for date
	 * @return date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Setter function for date
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/** 
	 * Getter function for room
	 * @return room
	 */
	public String getRoomName() {
		return roomName;
	}

	/**
	 * Setter function for room
	 * @param roomName
	 */
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	/**
	 * Getter function for begin time
	 * @return time
	 */
	public Timestamp getBeginTime() {
		return beginTime;
	}

	/**
	 * Setter function for begin time
	 * @param beginTime
	 */
	public void setBeginTime(Timestamp beginTime) {
		this.beginTime = beginTime;
	}

	/**
	 * Getter function for end time 
	 * @return time
	 */
	public Timestamp getEndTime() {
		return endTime;
	}

	/**
	 * Setter function for end time
	 * @param endTime
	 */
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	
	/**
	 * Setter function for begin time with end time
	 * @param times
	 */
	public void setBeginAndEndTime(Timestamp[] times) {
		this.beginTime = times[0];
		this.endTime = times[1];
	}

	/**
	 * Getter function for time
	 * @return time
	 */
	public int getTime() {
		return time;
	}

	/**
	 * Setter function for time
	 * @param time
	 */
	public void setTime(int time) {
		this.time = time;
	}

	/**
	 * Overrided function TOSTRING for best performance
	 */
	@Override
	public String toString() {
		return "Room [date=" + date + ", roomName=" + roomName + ", beginTime=" + beginTime + ", endTime=" + endTime
				+ ", time=" + time + "]";
	}

}
