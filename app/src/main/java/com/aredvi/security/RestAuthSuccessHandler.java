package com.aredvi.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;

import com.aredvi.entity.UserLogin;
import com.aredvi.repository.UserLoginRepo;


public class RestAuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	
	@Autowired
	UserLoginRepo userLoginRepo;
	
	private RequestCache requestCache = new HttpSessionRequestCache();

	@SuppressWarnings("unchecked")
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, 
			Authentication authentication)
	throws IOException, ServletException {
		
		SavedRequest savedRequest = requestCache.getRequest(request, response);
		UserLogin userLogin =  userLoginRepo.findByUserName(authentication.getName());
		
		response.setContentType("application/json");
		PrintWriter printWriter = response.getWriter();
		JSONObject obj = new JSONObject();
		obj.put("LoginResponse", "Success");
		obj.put("userId", userLogin.getId());
		obj.put("verified",userLogin.isVerified());
		obj.put("lock", userLogin.isLock());
		
		printWriter.print(obj);
		
		if(savedRequest == null) {
			clearAuthenticationAttributes(request);
			return;
		}
		
		String targetURLParam = getTargetUrlParameter();
		
		if(isAlwaysUseDefaultTargetUrl() 
				|| (targetURLParam != null && StringUtils.hasText(request.getParameter(targetURLParam)))
		){
			requestCache.removeRequest(request, response);
			clearAuthenticationAttributes(request);
			return;
		}
		
		clearAuthenticationAttributes(request);
	}
	
	public void setRequestCache(RequestCache requestCache) {
		
		this.requestCache = requestCache;
		
    }
}
