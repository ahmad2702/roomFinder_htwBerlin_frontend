package com.sadullaev.webProject.model;

import java.sql.Date;
import java.sql.Timestamp;
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
public class BookingList {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

	
	
	public BookingList(String room, Date date, Timestamp begin, Timestamp end, String status, List<User> users) {
		this.room = room;
		this.date = date;
		this.begin = begin;
		this.end = end;
		this.status = status;
		this.users = users;
	}

	public BookingList() {
		
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BookingList [id=" + id + ", room=" + room + ", date=" + date + ", begin=" + begin + ", end=" + end
				+ ", status=" + status + ", users=" + users + "]";
	}

	
	
	
}
