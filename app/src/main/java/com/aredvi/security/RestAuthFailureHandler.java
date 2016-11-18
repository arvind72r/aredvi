package com.aredvi.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;


public class RestAuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	
    @SuppressWarnings("unchecked")
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
    		AuthenticationException exception) throws IOException, ServletException {
    	
    	logger.debug("sending 401 Unauthorized error");
    	saveException(request, exception);
    	JSONObject obj = new JSONObject();
    	response.setContentType("application/json");
		PrintWriter printWriter = response.getWriter();
		obj.put("LoginResponse", "Authentication Failed: Invalid Username or Password");
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication Failed: " + exception.getMessage());
		printWriter.print(obj);
       
    }


}
