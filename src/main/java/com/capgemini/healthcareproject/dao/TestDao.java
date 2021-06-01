package com.capgemini.healthcareproject.dao;

import java.util.ArrayList;

import com.capgemini.healthcareproject.dto.Test;

public interface TestDao {
	

	public boolean addTest(Test test);
	
    public boolean deleteTest(int testId);
	
	public boolean updateTest(Test test);
	
	public ArrayList<Test> getAllTest();
	

}
