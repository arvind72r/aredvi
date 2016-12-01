package com.aredvi.exceptions;

public class AredviServiceException extends AredviException{

		private static final long serialVersionUID = 1L;
		
		public AredviServiceException() {
			super();
		}

		public AredviServiceException(String message, Throwable cause, 
				boolean enableSuppression, boolean writableStackTrace) {
			super(message, cause, enableSuppression, writableStackTrace);
		}

		public AredviServiceException(String message, Throwable cause) {
			super(message, cause);
		}

		public AredviServiceException(String message) {
			super(message);
		}

		public AredviServiceException(Throwable cause) {
			super(cause);
		}

		@Override
		public String getExceptionCode() {
			return ExceptionCode.USER_NOT_FOUND;
		}

}
