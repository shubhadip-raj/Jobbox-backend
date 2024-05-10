package com.jobbox.Project_Jobbox.controller;

public class PasswordUnmatchException extends RuntimeException {
	private String message;
	
	public PasswordUnmatchException(String message) {
		this.message=message;
		
	}
	
	public String getMessage() {
	     return message;
	}

}
