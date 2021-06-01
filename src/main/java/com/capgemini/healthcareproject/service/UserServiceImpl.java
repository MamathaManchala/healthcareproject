package com.capgemini.healthcareproject.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcareproject.dao.UserDao;
import com.capgemini.healthcareproject.dto.User;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public boolean registerUser(User user) {
		return userDao.registerUser(user);
	}

	@Override
	public User loginUser(User user) {
		return userDao.loginUser(user);
	}

	@Override
	public boolean updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public ArrayList<User> getAllUser() {
		return userDao.getAllUser();
	}

	@Override
	public boolean deleteUser(String userEmail) {
		return userDao.deleteUser(userEmail);
	}

}
