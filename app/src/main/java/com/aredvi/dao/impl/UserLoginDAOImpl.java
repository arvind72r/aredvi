package com.aredvi.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aredvi.dao.interfaces.UserLoginDAO;
import com.aredvi.exceptions.AredviException;
import com.aredvi.mysqlrepo.UserLoginRepo;
import com.aredvi.sqlentity.UserLogin;

@Repository("userLoginDAO")
public class UserLoginDAOImpl implements UserLoginDAO{

	@Autowired
    private UserLoginRepo userLoginRepo;
	
	@Override
	public UserLogin findByUserName(String username) {
		return userLoginRepo.findByUserName(username);
	}
	
	@Override
	public UserLogin findByAuthId(String authid) throws AredviException {
		return userLoginRepo.findByAuthId(authid);
	}

	@Override
	public UserLogin createLogin(UserLogin usrLogin) throws AredviException {
		return userLoginRepo.save(usrLogin);
	}

}
