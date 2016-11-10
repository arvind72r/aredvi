package com.aredvi.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aredvi.dto.request.ReqUserProfileDTO;
import com.aredvi.dto.response.RespUserProfileDTO;
import com.aredvi.exceptions.AredviException;
import com.aredvi.services.interfaces.UserService;
import com.aredvi.utils.RequestFormatter;
import com.aredvi.utils.ResponseFormatter;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Resource(name = "userService")
	private UserService usrService;

	@RequestMapping(value = "/addprofile", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseFormatter<RespUserProfileDTO> addUserProfile(
			@RequestBody RequestFormatter<ReqUserProfileDTO> pRequest) throws AredviException {
		RespUserProfileDTO respUserProfileDTO = usrService.addUserProfile(pRequest.getRequestData());
		ResponseFormatter<RespUserProfileDTO> resp = new ResponseFormatter<RespUserProfileDTO>();
		resp.setResponseData(respUserProfileDTO);
		return resp;
	}

	@RequestMapping(value = "/updateprofile", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseFormatter<RespUserProfileDTO> updateUserProfile(
			@RequestBody RequestFormatter<ReqUserProfileDTO> pRequest) throws AredviException {
		RespUserProfileDTO respUserProfileDTO = usrService.updateUserProfile(pRequest.getRequestData());
		ResponseFormatter<RespUserProfileDTO> resp = new ResponseFormatter<RespUserProfileDTO>();
		resp.setResponseData(respUserProfileDTO);
		return resp;
	}

	@RequestMapping(value = "/findprofile", method = RequestMethod.GET)
	public ResponseFormatter<RespUserProfileDTO> getUserProfile(@RequestParam String usrId) throws AredviException {
		RespUserProfileDTO respUserProfileDTO = usrService.getUserProfile(usrId);
		ResponseFormatter<RespUserProfileDTO> resp = new ResponseFormatter<RespUserProfileDTO>();
		resp.setResponseData(respUserProfileDTO);
		return resp;
	}

	@RequestMapping(value = "/searchbyname", method = RequestMethod.GET)
	public ResponseFormatter<List<RespUserProfileDTO>> searchUserByName(@RequestParam String name)
			throws AredviException {
		List<RespUserProfileDTO> profiles = usrService.searchUserByName(name);
		ResponseFormatter<List<RespUserProfileDTO>> resp = new ResponseFormatter<List<RespUserProfileDTO>>();
		resp.setResponseData(profiles);
		return resp;
	}

	@RequestMapping(value = "/searchbytype", method = RequestMethod.GET)
	public ResponseFormatter<List<RespUserProfileDTO>> searchUserByType(@RequestParam String type)
			throws AredviException {
		List<RespUserProfileDTO> profiles = usrService.searchUserByType(type);
		ResponseFormatter<List<RespUserProfileDTO>> resp = new ResponseFormatter<List<RespUserProfileDTO>>();
		resp.setResponseData(profiles);
		return resp;
	}
}
