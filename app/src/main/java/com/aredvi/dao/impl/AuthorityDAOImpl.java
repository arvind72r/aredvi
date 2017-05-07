package com.aredvi.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
		
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Authority.class);
		cr.add(Restrictions.eq("userRole", role));
		List<Authority> lAuth = cr.list();
		Authority authority = new Authority();
		if(lAuth!=null && lAuth.size()>0){
			authority = (Authority) lAuth.get(0);
		}else{
			authority = null;
		}
			
		return authority;
	}

}
