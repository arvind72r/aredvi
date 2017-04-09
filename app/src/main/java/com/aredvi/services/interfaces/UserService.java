package com.aredvi.services.interfaces;

import java.util.List;

import com.aredvi.dto.request.ReqLoginDTO;
import com.aredvi.dto.request.ReqUserProfileDTO;
import com.aredvi.dto.response.RespLoginDTO;
import com.aredvi.dto.response.RespUserProfileDTO;
import com.aredvi.sqlentity.UserLogin;
import com.aredvi.exceptions.AredviException;

public interface UserService {

	RespUserProfileDTO addUserProfile(ReqUserProfileDTO requestData) throws AredviException;

	RespUserProfileDTO updateUserProfile(ReqUserProfileDTO requestData) throws AredviException;

	RespUserProfileDTO getUserProfile(int usrId) throws AredviException;

	List<RespUserProfileDTO> searchUserByName(String name) throws AredviException;

	List<RespUserProfileDTO> searchUserByType(String type) throws AredviException;

	UserLogin createLogin(UserLogin usrLogin) throws AredviException;

	RespLoginDTO createLogin(ReqLoginDTO reqLoginDTO) throws AredviException;

	UserLogin findByUserName(String userName) throws AredviException;

	UserLogin findByAuthId(String authid) throws AredviException;

}
