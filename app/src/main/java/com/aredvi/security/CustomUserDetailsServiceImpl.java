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
import com.aredvi.entity.UserRole;
import com.aredvi.repository.AuthorityRepo;
import com.aredvi.repository.UserLoginRepo;
import com.aredvi.repository.UserRoleRepo;

@Service("userLoginService")
public class CustomUserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserLoginRepo userLoginRepo;
	
	@Autowired
	UserRoleRepo userRoleRepo;
	
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
			Set<UserRole> roles = new HashSet<UserRole>();
			Set<Authority> vAuthority = new HashSet<Authority>();
			roles = userRoleRepo.findByUserId(userLogin.getId());
			for(UserRole role : roles){
				vAuthority.add(authorityRepo.finByRole(role.getRole()));
			}
			boolean enabled = true;
			boolean accountNonExpired = true;
			boolean credentialsNonExpired = true;
			boolean accountNonLocked = true;
			return new User(userLogin.getUserName(), userLogin.getPassword(), 
					enabled, accountNonExpired, credentialsNonExpired, accountNonLocked,
					getAuthorities(roles,vAuthority));
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
				for(String permission : rap.getAuthorities()) {
					vAuthorities.add(new SimpleGrantedAuthority(permission));
				}
			}
		}
		return vAuthorities;
	}

}