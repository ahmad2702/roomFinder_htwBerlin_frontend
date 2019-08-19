package com.sadullaev.webProject.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="booking_list")
public class BookingList implements Serializable{
	
	/**
	 * Version
	 */
	private static final long serialVersionUID = 2L;

	/**
	 * Instance variables
	 */
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
	
	@Column(name = "room")
    private String room;
	
	@Column(name = "date")
    private Date date;
	
	@Column(name = "begin")
    private Timestamp begin;
	
	@Column(name = "end")
    private Timestamp end;
	
	@Column(name = "status")
    private String status;
	
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name = "booking_users_mapping", joinColumns = {
			@JoinColumn(name = "booking_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "user_id", referencedColumnName = "id") })
	private List<User> users;

	/**
	 * Constructor
	 * @param room
	 * @param date
	 * @param begin
	 * @param end
	 * @param status
	 * @param users
	 */
	public BookingList(String room, Date date, Timestamp begin, Timestamp end, String status, List<User> users) {
		this.room = room;
		this.date = date;
		this.begin = begin;
		this.end = end;
		this.status = status;
		this.users = users;
	}

	/**
	 * Constructor
	 */
	public BookingList() {
		
	}
	
	/**
	 * Getter function for room
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
	 * Getter function for begin time 
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
	 * Getter function for end time
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
	 * Getter function for user list
	 * @return user list
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * Setter function for user list
	 * @param users
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	/**
	 * Function to add new user
	 * @param user
	 */
	public void addUser(User user) {
		if(users==null || users.size()==0) {
			users = new ArrayList<User>();
		}
		users.add(user);
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
	 * Getter function for status
	 * @return status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Setter function for status
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Overrided function for best performance
	 */
	@Override
	public String toString() {
		return "BookingList [id=" + id + ", room=" + room + ", date=" + date + ", begin=" + begin + ", end=" + end
				+ ", status=" + status + ", users=" + users + "]";
	}

}
