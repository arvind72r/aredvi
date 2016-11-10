package com.aredvi.repository;

import org.springframework.data.repository.CrudRepository;

import com.aredvi.entity.UserLogin;

public interface UserLoginRepo extends CrudRepository<UserLogin, String>{

	UserLogin findByUserName(String username);

}
