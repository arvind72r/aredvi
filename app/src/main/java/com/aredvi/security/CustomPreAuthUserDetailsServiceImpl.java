package com.aredvi.security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aredvi.repository.AuthorityRepo;
import com.aredvi.repository.UserLoginRepo;
import com.aredvi.repository.UserRoleRepo;
import com.aredvi.repository.entity.Authority;
import com.aredvi.repository.entity.UserLogin;
import com.aredvi.repository.entity.UserRole;

@Service("customPreAuthUserDetailsService")
public class CustomPreAuthUserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserLoginRepo userLoginRepo;
	
	@Autowired
	UserRoleRepo userRoleRepo;
	
	@Autowired
	AuthorityRepo authorityRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		String password = "social";
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
			roles = userRoleRepo.findByUserId(userLogin.getUserId());
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
