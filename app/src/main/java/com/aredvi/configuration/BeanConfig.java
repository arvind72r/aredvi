package com.aredvi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.aredvi.dto.request.ReqDoctorProfileDTO;
import com.aredvi.dto.request.ReqLoginDTO;
import com.aredvi.dto.request.ReqUserProfileDTO;
import com.aredvi.dto.response.RespDoctorProfileDTO;
import com.aredvi.dto.response.RespLoginDTO;
import com.aredvi.dto.response.RespUserProfileDTO;
import com.aredvi.entity.Authority;
import com.aredvi.entity.Doctor;
import com.aredvi.entity.User;
import com.aredvi.entity.UserLogin;
import com.aredvi.entity.UserRole;


@Configuration
public class BeanConfig {
	
	@Bean(name="user")
	@Scope("prototype")
	public User getUserBean() {
		return new User();
	}
	
	@Bean(name="authority")
	@Scope("prototype")
	public Authority getAuthorityBean() {
		return new Authority();
	}
	
	@Bean(name="userLogin")
	@Scope("prototype")
	public UserLogin getUserLoginBean() {
		return new UserLogin();
	}
	
	@Bean(name="doctor")
	@Scope("prototype")
	public Doctor getDoctorBean() {
		return new Doctor();
	}
	
	@Bean(name="userRole")
	@Scope("prototype")
	public UserRole getUserRoleBean() {
		return new UserRole();
	}
	
	@Bean(name="reqDoctorProfileDTO")
	@Scope("prototype")
	public ReqDoctorProfileDTO getReqDoctorProfileDTOBean() {
		return new ReqDoctorProfileDTO();
	}
	
	@Bean(name="reqLoginDTO")
	@Scope("prototype")
	public ReqLoginDTO getReqLoginDTOBean() {
		return new ReqLoginDTO();
	}
	
	@Bean(name="reqUserProfileDTO")
	@Scope("prototype")
	public ReqUserProfileDTO getReqUserProfileDTOBean() {
		return new ReqUserProfileDTO();
	}
	
	@Bean(name="respDoctorProfileDTO")
	@Scope("prototype")
	public RespDoctorProfileDTO getRespDoctorProfileDTOBean() {
		return new RespDoctorProfileDTO();
	}
	
	@Bean(name="respLoginDTO")
	@Scope("prototype")
	public RespLoginDTO getRespLoginDTOBean() {
		return new RespLoginDTO();
	}
	
	@Bean(name="respUserProfileDTO")
	@Scope("prototype")
	public RespUserProfileDTO getRespUserProfileDTOBean() {
		return new RespUserProfileDTO();
	}
	
	
}
