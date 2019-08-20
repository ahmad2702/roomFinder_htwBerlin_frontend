package com.sadullaev.webProject.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="users")
public class User implements UserDetails {

	/**
	 * Version
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Instance variables
	 */
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
	
	@Column(name = "firstname")
    private String firstname;
	
	@Column(name = "lastname")
    private String lastname;
	
	@Column(name = "username")
    private String username;
	
	@Column(name = "password")
    private String password;
	
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name = "booking_users_mapping", joinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "booking_id", referencedColumnName = "id") })
	private List<BookingList> bookingList;

	/**
	 * Constructor
	 */
	public User() {
		
	}

	/**
	 * Constructor
	 * @param id
	 * @param firstname
	 * @param lastname
	 * @param username
	 * @param password
	 */
	public User(int id, String firstname, String lastname, String username, String password) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
	}
	
	/**
	 * Constructor
	 * @param firstname
	 * @param lastname
	 * @param username
	 * @param password
	 * @param bookingList
	 */
	public User(String firstname, String lastname, String username, String password, List<BookingList> bookingList) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.bookingList = bookingList;
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
	 * Getter function for firstname
	 * @return firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Setter function for firstname
	 * @param firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Getter function for lastname
	 * @return lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Setter function for lastname
	 * @param lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Getter function for username
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Setter function for username
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Getter function for password
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter function for password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Getter function booking list
	 * @return booking list
	 */
	public List<BookingList> getBookingList() {
		bookingList.sort(Comparator.comparing(BookingList::getDate).reversed());
		return bookingList;
	}

	/**
	 * Setter function for booking list
	 * @param bookingList
	 */
	public void setBookingList(List<BookingList> bookingList) {
		this.bookingList = bookingList;
	}
	
	/**
	 * Function for add new booking 
	 * @param booking
	 */
	public void addBooking(BookingList booking) {
		if(bookingList==null || bookingList.size()==0) {
			bookingList = new ArrayList<BookingList>();
		}
		
		bookingList.add(booking);
	}

	/**
	 * Overrided function for best performance
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", username=" + username
				+ "]";
	}
	
	/*
	 * Necessary functions from Class UserDetails 
	 */

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
