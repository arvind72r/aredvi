package com.aredvi.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aredvi.dao.interfaces.UserDAO;
import com.aredvi.exceptions.AredviException;
import com.aredvi.sqlentity.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {
	

	/*@Autowired
    private UserRepo userRepo;*/
	
	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public User addUserProfile(User user) throws AredviException {
		sessionFactory.getCurrentSession().save(user);
		return user;
	}

	@Override
	public User updateUserProfile(User user) throws AredviException {
		return (User)sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public List<User> searchUserByType(String type) throws AredviException {
		return null;
	}

	@Override
	public List<User> searchUserByName(String name) throws AredviException {
		return null;
	}

	@Override
	public User getUserProfile(int usrId) throws AredviException {
		return null;
	}

}
