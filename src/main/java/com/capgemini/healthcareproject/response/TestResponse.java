package com.capgemini.healthcareproject.response;

import java.util.List;

import com.capgemini.healthcareproject.dto.Test;


public class TestResponse {
	
	private int statusCode;
	private String message;
	private String description;
	private List<Test> test;
	
	
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
	public List<Test> getTest() {
		return test;
	}
	public void setTest(List<Test> test) {
		this.test = test;
	}
	
	
	

}
