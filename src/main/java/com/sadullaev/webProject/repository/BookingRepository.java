package com.sadullaev.webProject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sadullaev.webProject.model.BookingList;

@Repository
public interface BookingRepository extends CrudRepository<BookingList, Integer>{
	
	BookingList findById(int id);
	
}
