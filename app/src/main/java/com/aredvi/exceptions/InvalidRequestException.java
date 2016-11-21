package com.aredvi.exceptions;

public class InvalidRequestException extends AredviException{

	private static final long serialVersionUID = 1L;
	
	public InvalidRequestException() {
		super();
	}

	public InvalidRequestException(String message, Throwable cause, 
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidRequestException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidRequestException(String message) {
		super(message);
	}

	public InvalidRequestException(Throwable cause) {
		super(cause);
	}

	@Override
	public String getExceptionCode() {
		return ExceptionCode.INVALID_REQUEST_FORMAT;
	}

}
