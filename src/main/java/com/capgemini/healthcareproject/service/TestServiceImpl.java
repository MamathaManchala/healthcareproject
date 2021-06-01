package com.capgemini.healthcareproject.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcareproject.dao.TestDao;
import com.capgemini.healthcareproject.dto.Test;

@Service
public class TestServiceImpl implements TestService {

	
	@Autowired
    TestDao testDao;
	
	@Override
	public boolean addTest(Test test) {
		return testDao.addTest(test);
	}

	@Override
	public boolean deleteTest(int testId) {
		return testDao.deleteTest(testId);
	}

	@Override
	public boolean updateTest(Test test) {
		return testDao.updateTest(test);
	}

	@Override
	public ArrayList<Test> getAllTest() {
		return testDao.getAllTest();
	}

}
