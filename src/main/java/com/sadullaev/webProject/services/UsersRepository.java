package com.sadullaev.webProject.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sadullaev.webProject.model.User;

public interface UsersRepository extends JpaRepository<User, Integer> {
	
    User findByUsername(String username);
    
}