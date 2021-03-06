package com.aredvi.dao.interfaces;

import java.util.List;

import com.aredvi.sqlentity.User;
import com.aredvi.sqlentity.UserLogin;
import com.aredvi.exceptions.AredviException;

public interface UserDAO {

	User addUserProfile(User user) throws AredviException;

	User updateUserProfile(User user) throws AredviException;

	User getUserProfile(int usrId) throws AredviException;

	List<User> searchUserByType(String name) throws AredviException;

	List<User> searchUserByName(String name) throws AredviException;

}
