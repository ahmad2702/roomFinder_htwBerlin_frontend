package com.sadullaev.webProject.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sadullaev.webProject.model.BookingList;

@Repository
public interface BookingRepository extends CrudRepository<BookingList, Integer>{
	
	/**
	 * Function to find any booking by date into database
	 * @param date
	 * @param room
	 * @return booking list
	 */
	List<BookingList> findAllByDateAndRoom(Date date, String room);

}
