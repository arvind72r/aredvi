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
	

	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public User addUserProfile(User user) throws AredviException {
		return (User)sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public User updateUserProfile(User user) throws AredviException {
		return (User)sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public List<User> searchUserByType(String type) throws AredviException {
		return (List<User>)sessionFactory.getCurrentSession().get(User.class,type);
	}

	@Override
	public List<User> searchUserByName(String name) throws AredviException {
		return (List<User>)sessionFactory.getCurrentSession().get(User.class,name);
	}

	@Override
	public User getUserProfile(int usrId) throws AredviException {
		return null;
	}

}
