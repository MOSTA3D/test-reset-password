package com.testSecurity.demo.dto;

public class ErrorResponse {
	private String message;
	
	public ErrorResponse() {}

	public ErrorResponse(String message) {
		if(message != null) this.message = message;
		else this.message = "error";
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
