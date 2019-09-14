package com.sadullaev.webProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sadullaev.webProject.model.User;

public interface UsersRepository extends JpaRepository<User, Integer> {
	
	/**
	 * Function to find user into database
	 * @param username
	 * @return user
	 */
    User findByUsername(String username);
    
}