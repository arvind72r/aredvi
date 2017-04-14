package com.aredvi.mysqlrepo;

import org.springframework.data.repository.CrudRepository;

import com.aredvi.sqlentity.UserLogin;

public interface UserLoginRepo extends CrudRepository<UserLogin,Integer>{

	UserLogin findByUserName(String username);

	UserLogin findByAuthId(String authid);

}
