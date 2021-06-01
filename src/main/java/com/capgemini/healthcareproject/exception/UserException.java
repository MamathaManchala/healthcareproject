package com.capgemini.healthcareproject.exception;

public class UserException extends RuntimeException {
	
	String msg;

	public UserException(String msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;
	}

}
