package com.capgemini.healthcareproject.dao;

import java.util.ArrayList;

import com.capgemini.healthcareproject.dto.DiagnosticCenter;

public interface DiagnosticCenterDao {
	
	public boolean addCenter(DiagnosticCenter center);
	
	public boolean deleteCenter(int centerId);
	
	public boolean updateCenter(DiagnosticCenter center);
	
	public ArrayList<DiagnosticCenter> getAllCenter();
	

}
