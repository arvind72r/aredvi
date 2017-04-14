package com.aredvi.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aredvi.dao.interfaces.AuthorityDAO;
import com.aredvi.mysqlrepo.AuthorityRepo;
import com.aredvi.sqlentity.Authority;

@Repository("authorityDAO")
public class AuthorityDAOImpl implements AuthorityDAO{

	@Autowired
    private AuthorityRepo authorityRepo;
	
	@Override
	public Authority finByRole(String role) {
		return authorityRepo.findByUserRole(role);
	}

}
