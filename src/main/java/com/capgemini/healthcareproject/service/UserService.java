package com.capgemini.healthcareproject.service;

import java.util.ArrayList;

import com.capgemini.healthcareproject.dto.User;

public interface UserService {

   public boolean registerUser(User user);
	
	public User loginUser(User user);
	
	public boolean updateUser(User user);
	
	public ArrayList<User> getAllUser();
	
	public boolean deleteUser(String userEmail);
	
}
