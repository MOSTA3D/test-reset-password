package com.testSecurity.demo.dto;

public class MessageResponse {
	private String type;

	private String message;
	
	public MessageResponse() {}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public MessageResponse(String type, String message) {
		this.type = type;
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
