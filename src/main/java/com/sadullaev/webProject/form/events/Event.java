package com.sadullaev.webProject.form.events;

import java.sql.Date;
import java.sql.Timestamp;

public class Event {

	/**
	 * Instance variables
	 */
	
	private Date date;
    private Timestamp begin;
    private Timestamp end;
    private String name;
    private double lsf_id;    
    private String room;
    private String lecturer;
	
    /**
     * Constructor
     * @param date
     * @param begin
     * @param end
     * @param name
     * @param lsf_id
     * @param room
     * @param lecturer
     */
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

    /**
     * Getter function for Date
     * @return date
     */
	public Date getDate() {
		return date;
	}

	/**
	 * Setter function for Date
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Getter function for Begin time
	 * @return time
	 */
	public Timestamp getBegin() {
		return begin;
	}

	/**
	 * Setter function for begin time
	 * @param begin
	 */
	public void setBegin(Timestamp begin) {
		this.begin = begin;
	}

	/**
	 * Getter function for End time
	 * @return time
	 */
	public Timestamp getEnd() {
		return end;
	}

	/**
	 * Setter function for end time
	 * @param end
	 */
	public void setEnd(Timestamp end) {
		this.end = end;
	}

	/**
	 * Getter function for name
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter function for name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter function for lsf id
	 * @return lsf id
	 */
	public double getLsf_id() {
		return lsf_id;
	}

	/**
	 * Setter function for lsf id
	 * @param lsf_id
	 */
	public void setLsf_id(double lsf_id) {
		this.lsf_id = lsf_id;
	}

	/**
	 * Getter function room
	 * @return room
	 */
	public String getRoom() {
		return room;
	}

	/**
	 * Setter function for room
	 * @param room
	 */
	public void setRoom(String room) {
		this.room = room;
	}

	/**
	 * Getter function for lecturer
	 * @return lecturer
	 */
	public String getLecturer() {
		return lecturer;
	}

	/**
	 * Setter function for lecturer
	 * @param lecturer
	 */
	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}

	/**
	 * Overrided function TOSTRING for best performance
	 */
	@Override
	public String toString() {
		return "Event [date=" + date + ", begin=" + begin + ", end=" + end + ", name=" + name + ", lsf_id=" + lsf_id
				+ ", room=" + room + ", lecturer=" + lecturer + "]";
	}

}
