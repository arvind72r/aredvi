package com.aredvi.security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aredvi.entity.Authority;
import com.aredvi.entity.UserLogin;
import com.aredvi.repository.AuthorityRepo;
import com.aredvi.repository.UserLoginRepo;

@Service("userLoginService")
public class CustomUserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserLoginRepo userLoginRepo;
	
	@Autowired
	AuthorityRepo authorityRepo;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomUserDetailsServiceImpl.class);
	
	@Override
	public UserDetails loadUserByUsername(String username)
	throws UsernameNotFoundException {
		String password = null;
		UserLogin userLogin = userLoginRepo.findByUserName(username);
		if (userLogin != null) {
			password = userLogin.getPassword();
			if(password == null ) {
				throw new UsernameNotFoundException("Password is blank");
			} else if(password.length()<=0){
				throw new UsernameNotFoundException("Password is blank");
			}
			Set<Authority> vAuthority = new HashSet<Authority>();
			for(String role : userLogin.getRoles()){
				vAuthority.add(authorityRepo.finByRole(role));
			}
			boolean enabled = true;
			boolean accountNonExpired = true;
			boolean credentialsNonExpired = true;
			boolean accountNonLocked = true;
			return new User(userLogin.getUserName(), userLogin.getPassword(), 
					enabled, accountNonExpired, credentialsNonExpired, accountNonLocked,
					getAuthorities(userLogin.getRoles(),vAuthority));
		} else {
			throw new UsernameNotFoundException("could not find the user '" + username + "'");
		}
	}
		
	public List<GrantedAuthority> getAuthorities(List<String> roles, Set<Authority> authority){
		List<GrantedAuthority> vAuthorities = new ArrayList<GrantedAuthority>();
		for(String role: roles){
			vAuthorities.add(new SimpleGrantedAuthority(role));
		}
		if(authority != null && !authority.isEmpty()) {
			for(Authority rap : authority) {
				for(String permission : rap.getAuthorities()) {
					vAuthorities.add(new SimpleGrantedAuthority(permission));
				}
			}
		}
		return vAuthorities;
	}

}