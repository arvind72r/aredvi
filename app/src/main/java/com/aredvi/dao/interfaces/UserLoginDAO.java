package com.aredvi.dao.interfaces;

import com.aredvi.exceptions.AredviException;
import com.aredvi.sqlentity.UserLogin;

public interface UserLoginDAO {

	UserLogin findByUserName(String username) throws AredviException;
	
	public UserLogin findByAuthId(String authid) throws AredviException;
	
	public UserLogin createLogin(UserLogin usrLogin) throws AredviException;

}
