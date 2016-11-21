package com.aredvi.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsChecker;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

public class PreAuthProvider extends PreAuthenticatedAuthenticationProvider {
	private static final Logger LOGGER = LoggerFactory.getLogger(PreAuthProvider.class);

	private UserDetailsChecker vUserDetailsChecker = new AccountStatusUserDetailsChecker();

	private AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> preAuthenticatedUserDetailsService = null;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		if (!supports(authentication.getClass())) {
			return null;
		}

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("PreAuthenticated authentication request: " + authentication);
		}

		if (authentication.getPrincipal() == null) {
			LOGGER.debug("No pre-authenticated principal found in request.");
			throw new BadCredentialsException("No pre-authenticated principal found in request.");
		}

		if (authentication.getCredentials() == null) {
			LOGGER.debug("No pre-authenticated credentials found in request.");
			throw new BadCredentialsException("No pre-authenticated credentials found in request.");
		}

		UserDetails userDetails = preAuthenticatedUserDetailsService
				.loadUserDetails((PreAuthenticatedAuthenticationToken) authentication);

		vUserDetailsChecker.check(userDetails);

		PreAuthenticatedAuthenticationToken token = new PreAuthenticatedAuthenticationToken(userDetails,
				authentication.getCredentials(), userDetails.getAuthorities());
		token.setDetails(authentication.getDetails());

		return token;
	}

	public void setPreAuthenticatedUserDetailsService(
			AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> tokens) {
		super.setPreAuthenticatedUserDetailsService(tokens);
		this.preAuthenticatedUserDetailsService = tokens;
	}

}
