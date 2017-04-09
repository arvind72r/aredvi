package com.aredvi.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aredvi.dao.interfaces.AuthorityDAO;
import com.aredvi.sqlentity.Authority;

@Repository("authorityDAO")
public class AuthorityDAOImpl implements AuthorityDAO{

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public Authority finByRole(String role) {
		return (Authority)sessionFactory.getCurrentSession().get(Authority.class,role);
	}

}
