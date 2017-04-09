package com.aredvi.security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aredvi.dao.interfaces.AuthorityDAO;
import com.aredvi.dao.interfaces.UserLoginDAO;
import com.aredvi.exceptions.AredviException;
import com.aredvi.sqlentity.Authority;
import com.aredvi.sqlentity.UserLogin;
import com.aredvi.sqlentity.UserRole;

@Service("userLoginService")
public class CustomUserDetailsServiceImpl implements UserDetailsService {
	
	@Resource(name = "userLoginDAO")
	UserLoginDAO userLoginDAO;
	
	@Resource(name = "authorityDAO")
	AuthorityDAO authorityDAO;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomUserDetailsServiceImpl.class);
	
	@Override
	public UserDetails loadUserByUsername(String username)
	throws UsernameNotFoundException {
		String password = null;
		UserLogin userLogin =null;
		try {
			userLogin = userLoginDAO.findByUserName(username);
		} catch (AredviException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (userLogin != null) {
			password = userLogin.getPassword();
			if(password == null ) {
				throw new UsernameNotFoundException("Password is blank");
			} else if(password.length()<=0){
				throw new UsernameNotFoundException("Password is blank");
			}
			Set<Authority> vAuthority = new HashSet<Authority>();
			for(UserRole role : userLogin.getUserRole()){
				vAuthority.add(authorityDAO.finByRole(role.getRole()));
			}
			boolean enabled = true;
			boolean accountNonExpired = true;
			boolean credentialsNonExpired = true;
			boolean accountNonLocked = true;
			return new User(userLogin.getUserName(), userLogin.getPassword(), 
					enabled, accountNonExpired, credentialsNonExpired, accountNonLocked,
					getAuthorities(userLogin.getUserRole(),vAuthority));
		} else {
			throw new UsernameNotFoundException("could not find the user '" + username + "'");
		}
	}
		
	public List<GrantedAuthority> getAuthorities(Set<UserRole> roles, Set<Authority> authority){
		List<GrantedAuthority> vAuthorities = new ArrayList<GrantedAuthority>();
		for(UserRole role: roles){
			vAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
		}
		if(authority != null && !authority.isEmpty()) {
			for(Authority rap : authority) {
					vAuthorities.add(new SimpleGrantedAuthority(rap.getAuth()));
			}
		}
		return vAuthorities;
	}

}