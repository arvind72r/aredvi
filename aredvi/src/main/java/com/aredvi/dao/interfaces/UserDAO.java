package com.aredvi.dao.interfaces;

import java.util.List;

import com.aredvi.entity.User;
import com.aredvi.exceptions.AredviException;

public interface UserDAO {

	User addUserProfile(User user) throws AredviException;

	User updateUserProfile(User user) throws AredviException;

	User getUserProfile(String usrId) throws AredviException;

	List<User> searchUserByType(String name) throws AredviException;

	List<User> searchUserByName(String name) throws AredviException;

}
