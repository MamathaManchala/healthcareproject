package com.capgemini.healthcareproject.response;

import java.util.List;

import com.capgemini.healthcareproject.dto.DiagnosticCenter;


public class CenterResponse {
	
	private int statusCode;
	private String message;
	private String description;
	private List<DiagnosticCenter> center;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<DiagnosticCenter> getCenter() {
		return center;
	}
	public void setCenter(List<DiagnosticCenter> center) {
		this.center = center;
	}
	
	

	
	

}
