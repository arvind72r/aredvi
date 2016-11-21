package com.aredvi.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component("restAuthenticationEntryPoint")
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
	
	@Override
	public void commence(HttpServletRequest pRequest,
			HttpServletResponse pResponse, AuthenticationException pAuthException)
			throws IOException, ServletException {
		pResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Unauthorized");
		
	}

}
