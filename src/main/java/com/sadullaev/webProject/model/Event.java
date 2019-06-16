package com.sadullaev.webProject.model;

import java.sql.Date;
import java.sql.Timestamp;

public class Event {
	
	private Date date;
    private Timestamp begin;
    private Timestamp end;
    private String name;
    private double lsf_id;    
    private String room;
    private String lecturer;
	
    public Event(Date date, Timestamp begin, Timestamp end, String name, double lsf_id, String room, String lecturer) {
		super();
		this.date = date;
		this.begin = begin;
		this.end = end;
		this.name = name;
		this.lsf_id = lsf_id;
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

	public double getLsf_id() {
		return lsf_id;
	}

	public void setLsf_id(double lsf_id) {
		this.lsf_id = lsf_id;
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
		return "Event [date=" + date + ", begin=" + begin + ", end=" + end + ", name=" + name + ", lsf_id=" + lsf_id
				+ ", room=" + room + ", lecturer=" + lecturer + "]";
	}

	
}
