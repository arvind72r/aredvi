package com.aredvi.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aredvi.dao.QueryUtil;
import com.aredvi.dao.interfaces.UserLoginDAO;
import com.aredvi.exceptions.AredviException;
import com.aredvi.sqlentity.UserLogin;

@Repository("userLoginDAO")
public class UserLoginDAOImpl implements UserLoginDAO{

	/*@Autowired
    private UserLoginRepo userLoginRepo;*/
	
	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public UserLogin findByUserName(String username) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(UserLogin.class);
		cr.add(Restrictions.eq("userName", username));
		List usr = cr.list();
		UserLogin usrObj = new UserLogin();
		//Iterator iter = usr.iterator();
		if(usr!=null && usr.size()>0){
			usrObj = (UserLogin) usr.get(0);
		}else{
			usrObj = null;
		}
			
		return usrObj;
	}
	
	@Override
	public UserLogin findByAuthId(String authid) throws AredviException {
		return null;
	}

	@Override
	public UserLogin createLogin(UserLogin usrLogin) throws AredviException {
		  sessionFactory.getCurrentSession().save(usrLogin);
		  return findByUserName(usrLogin.getUserName());
	}

}
