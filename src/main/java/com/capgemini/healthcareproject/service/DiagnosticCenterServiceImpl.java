package com.capgemini.healthcareproject.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.healthcareproject.dao.DiagnosticCenterDao;
import com.capgemini.healthcareproject.dto.DiagnosticCenter;
@Service
public class DiagnosticCenterServiceImpl implements DiagnosticCenterService {

	@Autowired
	DiagnosticCenterDao centerDao;
	
	@Override
	public boolean addCenter(DiagnosticCenter center) {
		return centerDao.addCenter(center);
	}

	@Override
	public boolean deleteCenter(int centerId) {
		return centerDao.deleteCenter(centerId);
	}

	@Override
	public boolean updateCenter(DiagnosticCenter center) {
		return centerDao.updateCenter(center);
	}

	@Override
	public ArrayList<DiagnosticCenter> getAllCenter() {
		return centerDao.getAllCenter();
	}



}
