package com.capgemini.healthcareproject.dao;

import java.util.ArrayList;

import com.capgemini.healthcareproject.dto.User;

public interface UserDao {
	
	public boolean registerUser(User user);
	
	public User loginUser(User user);
	
	public boolean updateUser(User user);
	
	public ArrayList<User> getAllUser();
	
	public boolean deleteUser(String userEmail);
	

}
