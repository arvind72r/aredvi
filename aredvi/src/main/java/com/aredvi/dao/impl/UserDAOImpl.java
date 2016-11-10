package com.aredvi.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aredvi.dao.interfaces.UserDAO;
import com.aredvi.entity.User;
import com.aredvi.exceptions.AredviException;
import com.aredvi.repository.UserRepo;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	UserRepo userRepo;

	@Override
	public User addUserProfile(User user) throws AredviException {
		return userRepo.save(user);
	}

	@Override
	public User updateUserProfile(User user) throws AredviException {
		return userRepo.save(user);
	}

	@Override
	public User getUserProfile(String usrId) throws AredviException {
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

}
