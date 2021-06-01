package com.capgemini.healthcareproject.exception;

public class CenterException extends RuntimeException {
	
	String msg;

	public CenterException(String msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;
	}

}
