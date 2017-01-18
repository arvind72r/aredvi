package com.aredvi.services.impl;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aredvi.dao.interfaces.UserDAO;
import com.aredvi.dto.request.ReqLoginDTO;
import com.aredvi.dto.request.ReqUserProfileDTO;
import com.aredvi.dto.response.RespLoginDTO;
import com.aredvi.dto.response.RespUserProfileDTO;
import com.aredvi.entity.User;
import com.aredvi.entity.UserLogin;
import com.aredvi.exceptions.AredviException;
import com.aredvi.services.interfaces.UserService;
import com.aredvi.utils.Roles;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource(name = "userDAO")
	private UserDAO userDAO;

	@Override
	public RespUserProfileDTO addUserProfile(ReqUserProfileDTO requestData) throws AredviException {
		RespUserProfileDTO respUserProfileDTO = new RespUserProfileDTO();
		User user = convertRequestToEntity(requestData);
		user = userDAO.addUserProfile(user);
		swapData(respUserProfileDTO,user);
		return respUserProfileDTO;
	}

	@Override
	public RespUserProfileDTO updateUserProfile(ReqUserProfileDTO requestData) throws AredviException {
		RespUserProfileDTO respUserProfileDTO = new RespUserProfileDTO();
		User user = convertRequestToEntity(requestData);
		user = userDAO.updateUserProfile(user);
		swapData(respUserProfileDTO,user);
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
		swapData(user,requestData);
		return user;
	}

	public RespUserProfileDTO convertEntityToResponse(User user) throws AredviException {
		RespUserProfileDTO respUserProfileDTO = new RespUserProfileDTO();
		swapData(respUserProfileDTO,user);
		return respUserProfileDTO;
	}
	
	public void swapData(User user,ReqUserProfileDTO requestData){
		if(null != requestData){
			user.setAllergies(requestData.getAllergies());
			user.setCity(requestData.getCity());
			user.setDob(requestData.getDob());
			user.setEmail(requestData.getEmail());
			user.setFamilyPhysician(requestData.getFamilyPhysician());
			user.setFname(requestData.getFname());
			user.setGender(requestData.getGender());
			if(null != requestData.getId()){
			user.setId(requestData.getId());
			}
			user.setLname(requestData.getLname());
			user.setParentId(requestData.getParentId());
			user.setMobileNumber(requestData.getMobileNumber());
			user.setType(requestData.getType());
			user.setUserLoginId(requestData.getUserLoginId());
		}
	}
	
	public void swapData(RespUserProfileDTO respData, User user){
		if(null != user){
		respData.setAllergies(user.getAllergies());
		respData.setCity(user.getCity());
		respData.setDob(user.getDob());
		respData.setEmail(user.getEmail());
		respData.setFamilyPhysician(user.getFamilyPhysician());
		respData.setFname(user.getFname());
		respData.setGender(user.getGender());
		respData.setId(user.getId());
		respData.setLname(user.getLname());
		respData.setParentId(user.getParentId());
		respData.setMobileNumber(user.getMobileNumber());
		respData.setType(user.getType());
		respData.setUserLoginId(user.getUserLoginId());
		}
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

	@Override
	public RespLoginDTO createLogin(ReqLoginDTO reqLoginDTO) throws AredviException {
		UserLogin userLogin = new UserLogin();
		RespLoginDTO respLoginDTO = new RespLoginDTO();
		convertRequestToEntity(userLogin, reqLoginDTO);
		userLogin = createLogin(userLogin);
		convertRequestToEntity(respLoginDTO,userLogin);
		return respLoginDTO;
	}

	private void convertRequestToEntity(RespLoginDTO respLoginDTO, UserLogin userLogin) {
		respLoginDTO.setUserLoginId(respLoginDTO.getUserLoginId());
	}

	private void convertRequestToEntity(UserLogin userLogin, ReqLoginDTO reqLoginDTO) {
		List<String> roles = new ArrayList<String>();
		roles.add(Roles.ROLE_USER.getRole());
		userLogin.setPassword(getMD5(reqLoginDTO.getPassword()));
		userLogin.setUserName(reqLoginDTO.getUserName());
		userLogin.setRoles(roles);
		userLogin.setCreatedOn(new Date());
		if(null != reqLoginDTO.getUserLoginId()){
			userLogin.setId(reqLoginDTO.getUserLoginId());
			userLogin.setUpdatedOn(new Date());
		}
	}

	@Override
	public UserLogin findByUserName(String userName) throws AredviException {
		return userDAO.findByUserName(userName);
	}
	
	
	public static String getMD5(String input) {
    try {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(input.getBytes());
        BigInteger number = new BigInteger(1, messageDigest);
        String hashtext = number.toString(16);
        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        return hashtext;
    }
    catch (NoSuchAlgorithmException e) {
        throw new RuntimeException(e);
    }
}
}
