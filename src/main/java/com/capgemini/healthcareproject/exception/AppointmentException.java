package com.capgemini.healthcareproject.exception;

public class AppointmentException extends RuntimeException {
	
	String msg;

	public AppointmentException(String msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;
	}

}
