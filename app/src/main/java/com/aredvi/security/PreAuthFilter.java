package com.aredvi.security;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

import com.aredvi.exceptions.AredviException;
import com.aredvi.repository.entity.UserLogin;
import com.aredvi.services.interfaces.UserService;
import com.aredvi.utils.UtilityService;

public class PreAuthFilter extends AbstractPreAuthenticatedProcessingFilter {

	@Resource(name = "userService")
	private UserService userService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PreAuthFilter.class);


	@Override
	protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {

		String authProvider = request.getHeader("authprovider");
		String authid = request.getHeader("authid");

		if (authProvider != null && authid != null
				&& (authProvider.equalsIgnoreCase("FACE_BOOK")
						|| authProvider.equalsIgnoreCase("GOOGLE_PLUS"))) {
			try {
				UserLogin usrLogin = userService.findByAuthId(authid);
				if (usrLogin != null) {
					userService.createLogin(usrLogin);
					return authid;
				} else {
					createUser(authid, authProvider);
					return authid;
				}
			} catch (AredviException e) {
				UtilityService.writeLog(LOGGER, e);
			}
		}

		return null;
	}

	private void createUser(String email, String provider) {
		try {	
			UserLogin userLogin = new UserLogin();
			userLogin.setAuthId(email);
			userLogin.setAuthProvider(provider);
			userLogin = userService.createLogin(userLogin);

		} catch (AredviException ex) {
			UtilityService.writeLog(LOGGER, ex);
		}
	}




	@Override
	protected Object getPreAuthenticatedCredentials(HttpServletRequest pRequest) {
		return "socialUser";
	}

}
