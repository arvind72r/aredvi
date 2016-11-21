package com.aredvi.dao.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import com.aredvi.dao.interfaces.UserDAO;
import com.aredvi.entity.User;
import com.aredvi.entity.UserLogin;
import com.aredvi.exceptions.AredviException;
import com.aredvi.repository.UserLoginRepo;
import com.aredvi.repository.UserRepo;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private CassandraOperations cassandraOperations;


	@Autowired
	UserRepo userRepo;
	
	@Autowired
	UserLoginRepo userLoginRepo;

	@Override
	public User addUserProfile(User user) throws AredviException {
		return cassandraOperations.insert(user);
	}

	@Override
	public User updateUserProfile(User user) throws AredviException {
		return userRepo.save(user);
	}

	@Override
	public User getUserProfile(UUID usrId) throws AredviException {
		return userRepo.findById(usrId);
	}

	@Override
	public List<User> searchUserByType(String type) throws AredviException {
		return userRepo.findByType(type);
	}

	@Override
	public List<User> searchUserByName(String name) throws AredviException {
		return userRepo.findByName(name);
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
