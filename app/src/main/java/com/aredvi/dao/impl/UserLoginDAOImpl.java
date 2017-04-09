package com.aredvi.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aredvi.dao.interfaces.UserLoginDAO;
import com.aredvi.exceptions.AredviException;
import com.aredvi.sqlentity.UserLogin;

@Repository("userLoginDAO")
public class UserLoginDAOImpl implements UserLoginDAO{

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public UserLogin findByUserName(String username) {
		return (UserLogin)sessionFactory.getCurrentSession().get(UserLogin.class,username);
	}
	
	@Override
	public UserLogin findByAuthId(String authid) throws AredviException {
		return (UserLogin)sessionFactory.getCurrentSession().get(UserLogin.class,authid);
	}

	@Override
	public UserLogin createLogin(UserLogin usrLogin) throws AredviException {
		UserLogin userLogin = (UserLogin)sessionFactory.getCurrentSession().save(usrLogin);
		return userLogin;
	}

}
