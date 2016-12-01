package com.aredvi.dao.interfaces;

import java.util.List;
import java.util.UUID;

import com.aredvi.entity.User;
import com.aredvi.entity.UserLogin;
import com.aredvi.exceptions.AredviException;

public interface UserDAO {

	User addUserProfile(User user) throws AredviException;

	User updateUserProfile(User user) throws AredviException;

	User getUserProfile(UUID usrId) throws AredviException;

	List<User> searchUserByType(String name) throws AredviException;

	List<User> searchUserByName(String name) throws AredviException;

	UserLogin findByAuthId(String authid) throws AredviException;

	UserLogin createLogin(UserLogin usrLogin) throws AredviException;

	UserLogin findByUserName(String userName) throws AredviException;

}
