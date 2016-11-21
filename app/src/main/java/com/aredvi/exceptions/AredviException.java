package com.aredvi.exceptions;

public abstract class AredviException extends Exception {
	private static final long serialVersionUID = 1L;

	public AredviException() {
		super();
	}

	public AredviException(String message, Throwable cause, 
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AredviException(String message, Throwable cause) {
		super(message, cause);
	}

	public AredviException(String message) {
		super(message);
	}

	public AredviException(Throwable cause) {
		super(cause);
	}
	
	public abstract String getExceptionCode();
}
