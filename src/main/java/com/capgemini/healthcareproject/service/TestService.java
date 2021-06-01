package com.capgemini.healthcareproject.service;

import java.util.ArrayList;

import com.capgemini.healthcareproject.dto.Test;

public interface TestService {

	public boolean addTest(Test test);
	
	 public boolean deleteTest(int testId);
		
		public boolean updateTest(Test test);
		
		public ArrayList<Test> getAllTest();
}
