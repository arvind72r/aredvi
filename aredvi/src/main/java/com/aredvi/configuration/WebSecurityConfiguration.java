package com.aredvi.configuration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.aredvi.entity.Authority;
import com.aredvi.entity.UserLogin;
import com.aredvi.entity.UserRole;
import com.aredvi.repository.AuthorityRepo;
import com.aredvi.repository.UserLoginRepo;
import com.aredvi.repository.UserRoleRepo;

@Configuration
public class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {
	@Autowired
	UserLoginRepo userLoginRepo;
	
	@Autowired
	UserRoleRepo userRoleRepo;
	
	@Autowired
	AuthorityRepo authorityRepo;

	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService());
	}

	@Bean
	UserDetailsService userDetailsService() {
		return new UserDetailsService() {

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

		};
	}
	
	public List<GrantedAuthority> getAuthorities(Set<UserRole> pRoles, Set<Authority> pAuthority){
		List<GrantedAuthority> vAuthorities = new ArrayList<GrantedAuthority>();
		for(UserRole vRole: pRoles){
			vAuthorities.add(new SimpleGrantedAuthority(vRole.getRole()));
		}
		if(pAuthority != null && !pAuthority.isEmpty()) {
			for(Authority rap : pAuthority) {
				for(String permission : rap.getAuthorities()) {
					vAuthorities.add(new SimpleGrantedAuthority(permission));
				}
			}
		}
		return vAuthorities;
	}
}
