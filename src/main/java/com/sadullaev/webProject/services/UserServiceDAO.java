package com.sadullaev.webProject.services;

import com.sadullaev.webProject.model.User;

public interface UserServiceDAO {

	User getUser(String login);
	
}
