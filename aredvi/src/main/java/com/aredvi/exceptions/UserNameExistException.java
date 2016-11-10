package com.aredvi.exceptions;

public class UserNameExistException extends AredviException{

	private static final long serialVersionUID = 1L;
	
	public UserNameExistException() {
		super();
	}

	public UserNameExistException(String message, Throwable cause, 
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserNameExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserNameExistException(String message) {
		super(message);
	}

	public UserNameExistException(Throwable cause) {
		super(cause);
	}

	@Override
	public String getExceptionCode() {
		return ExceptionCode.USER_EXISTS;
	}

}
