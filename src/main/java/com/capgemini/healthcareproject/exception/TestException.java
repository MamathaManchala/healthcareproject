package com.capgemini.healthcareproject.exception;

public class TestException extends RuntimeException{

	String msg;

	public TestException(String msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;
	}
}
