package com.aredvi.exceptions;

import javax.servlet.http.HttpServletResponse;

public class ExceptionCode {
	public static final String USER_NOT_FOUND = Integer.toString(HttpServletResponse.SC_NOT_FOUND);
	
	public static final String INVALID_REQUEST_FORMAT = Integer.toString(HttpServletResponse.SC_BAD_REQUEST);
	
	public static final String INTERNAL_SERVER_ERROR =Integer.toString(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	
	public static final String QUERY_NOT_SPECIFIED =Integer.toString(HttpServletResponse.SC_NOT_FOUND);
	
	public static final String USER_EXISTS = Integer.toString(HttpServletResponse.SC_FORBIDDEN);
	
	private ExceptionCode() {
		
	}
}
