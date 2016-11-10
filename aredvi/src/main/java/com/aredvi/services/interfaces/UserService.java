package com.aredvi.services.interfaces;

import java.util.List;

import com.aredvi.dto.request.ReqUserProfileDTO;
import com.aredvi.dto.response.RespUserProfileDTO;
import com.aredvi.exceptions.AredviException;

public interface UserService {

	RespUserProfileDTO addUserProfile(ReqUserProfileDTO requestData) throws AredviException;

	RespUserProfileDTO updateUserProfile(ReqUserProfileDTO requestData) throws AredviException;

	RespUserProfileDTO getUserProfile(String usrId) throws AredviException;

	List<RespUserProfileDTO> searchUserByName(String name) throws AredviException;

	List<RespUserProfileDTO> searchUserByType(String type) throws AredviException;

}
