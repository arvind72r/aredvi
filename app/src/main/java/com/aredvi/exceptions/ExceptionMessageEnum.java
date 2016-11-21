package com.aredvi.exceptions;

public enum ExceptionMessageEnum {
	INVALID_REQUEST_FORMAT("Invalid Request Format.");
	private String message;

	private ExceptionMessageEnum(String exception) {
		message = exception;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
