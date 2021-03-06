package com.aredvi.exceptions;

public class UserNotFoundException extends AredviException{

	private static final long serialVersionUID = 1L;
	
	public UserNotFoundException() {
		super();
	}

	public UserNotFoundException(String message, Throwable cause, 
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserNotFoundException(String message) {
		super(message);
	}

	public UserNotFoundException(Throwable cause) {
		super(cause);
	}

	@Override
	public String getExceptionCode() {
		return ExceptionCode.USER_NOT_FOUND;
	}

}
