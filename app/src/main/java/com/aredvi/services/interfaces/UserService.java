package com.aredvi.services.interfaces;

import java.util.List;
import java.util.UUID;

import com.aredvi.dto.request.ReqUserProfileDTO;
import com.aredvi.dto.response.RespUserProfileDTO;
import com.aredvi.entity.UserLogin;
import com.aredvi.exceptions.AredviException;

public interface UserService {

	RespUserProfileDTO addUserProfile(ReqUserProfileDTO requestData) throws AredviException;

	RespUserProfileDTO updateUserProfile(ReqUserProfileDTO requestData) throws AredviException;

	RespUserProfileDTO getUserProfile(UUID usrId) throws AredviException;

	List<RespUserProfileDTO> searchUserByName(String name) throws AredviException;

	List<RespUserProfileDTO> searchUserByType(String type) throws AredviException;

	UserLogin findByAuthId(String authid) throws AredviException;

	UserLogin createLogin(UserLogin usrLogin) throws AredviException;

}
