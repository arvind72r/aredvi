package com.aredvi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.aredvi.repository.entity.User;
import com.aredvi.repository.entity.UserLogin;


@Configuration
public class BeanConfig {
	
	@Bean
	@Scope("prototype")
	public User getUserBean() {
		return new User();
	}
	
	@Bean
	@Scope("prototype")
	public UserLogin getUserLoginBean() {
		return new UserLogin();
	}
}
