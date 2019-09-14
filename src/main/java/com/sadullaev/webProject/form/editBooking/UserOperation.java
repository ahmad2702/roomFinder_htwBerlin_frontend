package com.sadullaev.webProject.form.editBooking;

public class UserOperation {
	
	/**
	 * Instance variables
	 */
	
	private int bookingId;
	private int userId;
	private String username;
	
	/**
	 * Getter function for booking id
	 * @return booking id
	 */
	public int getBookingId() {
		return bookingId;
	}
	
	/**
	 * Setter function for booking id
	 * @param bookingId
	 */
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	
	/**
	 * Getter function for user id
	 * @return user id
	 */
	public int getUserId() {
		return userId;
	}
	
	/**
	 * Setter function for user id
	 * @param userId
	 */
	public void setUserId(int userId) {
		this.userId = userId;
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

}
