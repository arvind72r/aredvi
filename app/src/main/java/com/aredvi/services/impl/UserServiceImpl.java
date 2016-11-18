package com.aredvi.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aredvi.dao.interfaces.UserDAO;
import com.aredvi.dto.request.ReqUserProfileDTO;
import com.aredvi.dto.response.RespUserProfileDTO;
import com.aredvi.exceptions.AredviException;
import com.aredvi.repository.entity.User;
import com.aredvi.repository.entity.UserLogin;
import com.aredvi.services.interfaces.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource(name = "userDAO")
	private UserDAO userDAO;

	@Override
	public RespUserProfileDTO addUserProfile(ReqUserProfileDTO requestData) throws AredviException {
		RespUserProfileDTO respUserProfileDTO = new RespUserProfileDTO();
		User user = convertRequestToEntity(requestData);
		user = userDAO.addUserProfile(user);
		return respUserProfileDTO;
	}

	@Override
	public RespUserProfileDTO updateUserProfile(ReqUserProfileDTO requestData) throws AredviException {
		RespUserProfileDTO respUserProfileDTO = new RespUserProfileDTO();
		User user = convertRequestToEntity(requestData);
		user = userDAO.updateUserProfile(user);
		// Convertion code here
		return respUserProfileDTO;
	}

	@Override
	public RespUserProfileDTO getUserProfile(UUID usrId) throws AredviException {
		RespUserProfileDTO respUserProfileDTO = new RespUserProfileDTO();
		User user = userDAO.getUserProfile(usrId);
		respUserProfileDTO = convertEntityToResponse(user);
		return respUserProfileDTO;
	}

	@Override
	public List<RespUserProfileDTO> searchUserByName(String name) throws AredviException {
		List<RespUserProfileDTO> respUserProfileDTOs = new ArrayList<RespUserProfileDTO>();
		List<User> users = userDAO.searchUserByName(name);
		for (User user : users) {
			respUserProfileDTOs.add(convertEntityToResponse(user));
		}
		return respUserProfileDTOs;
	}

	@Override
	public List<RespUserProfileDTO> searchUserByType(String type) throws AredviException {
		List<RespUserProfileDTO> respUserProfileDTOs = new ArrayList<RespUserProfileDTO>();
		List<User> users = userDAO.searchUserByType(type);
		for (User user : users) {
			respUserProfileDTOs.add(convertEntityToResponse(user));
		}
		return respUserProfileDTOs;
	}

	public User convertRequestToEntity(ReqUserProfileDTO requestData) throws AredviException {
		User user = new User();
		user.setName(requestData.getName());
		user.setType(requestData.getType());
		return user;
	}

	public RespUserProfileDTO convertEntityToResponse(User user) throws AredviException {
		RespUserProfileDTO respUserProfileDTO = null;
		return respUserProfileDTO;
	}

	@Override
	public UserLogin findByAuthId(String authid) throws AredviException {
		UserLogin userLogin = userDAO.findByAuthId(authid);
		return userLogin;
	}

	@Override
	public UserLogin createLogin(UserLogin usrLogin) throws AredviException {
		UserLogin userLogin = userDAO.createLogin(usrLogin);
		return userLogin;
	}
}
