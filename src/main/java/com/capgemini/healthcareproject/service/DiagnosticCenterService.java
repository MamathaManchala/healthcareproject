package com.capgemini.healthcareproject.service;

import java.util.ArrayList;

import com.capgemini.healthcareproject.dto.DiagnosticCenter;

public interface DiagnosticCenterService {

public boolean addCenter(DiagnosticCenter center);
	
	public boolean deleteCenter(int centerId);
	
	public boolean updateCenter(DiagnosticCenter center);
	
	public ArrayList<DiagnosticCenter> getAllCenter();
	
}
