package com.sadullaev.webProject.model;

import java.sql.Date;
import java.sql.Timestamp;

public class Event {
	
	private Date date;
    private Timestamp begin;
    private Timestamp end;
    private String name;
    private double lsfId;    
    private String room;
    private String lecturer;
	
    public Event(Date date, Timestamp begin, Timestamp end, String name, double lsfId, String room, String lecturer) {
		super();
		this.date = date;
		this.begin = begin;
		this.end = end;
		this.name = name;
		this.lsfId = lsfId;
		this.room = room;
		this.lecturer = lecturer;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Timestamp getBegin() {
		return begin;
	}

	public void setBegin(Timestamp begin) {
		this.begin = begin;
	}

	public Timestamp getEnd() {
		return end;
	}

	public void setEnd(Timestamp end) {
		this.end = end;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLsfId() {
		return lsfId;
	}

	public void setLsfId(double lsfId) {
		this.lsfId = lsfId;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getLecturer() {
		return lecturer;
	}

	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}

	@Override
	public String toString() {
		return "Event [date=" + date + ", begin=" + begin + ", end=" + end + ", name=" + name + ", lsfId=" + lsfId
				+ ", room=" + room + ", lecturer=" + lecturer + "]";
	}
    
    
	
}
