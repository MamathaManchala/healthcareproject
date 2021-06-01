package com.capgemini.healthcareproject.response;

import java.util.List;

import com.capgemini.healthcareproject.dto.Appointment;

public class AppointmentResponse {
	
	private int statusCode;
	private String message;
	private String description;
	private List<Appointment> appointment;
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
	public List<Appointment> getAppointment() {
		return appointment;
	}
	public void setAppointment(List<Appointment> appointment) {
		this.appointment = appointment;
	}
	
	
	
	

}
