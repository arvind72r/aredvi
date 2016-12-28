package com.aredvi.controller;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aredvi.dto.request.ReqDoctorProfileDTO;
import com.aredvi.dto.response.RespDoctorProfileDTO;
import com.aredvi.exceptions.AredviException;
import com.aredvi.services.interfaces.DoctorService;
import com.aredvi.utils.RequestFormatter;
import com.aredvi.utils.ResponseFormatter;

@RestController
@RequestMapping(value = "/doctor")
public class DoctorController {

	@Resource(name = "doctorService")
	private DoctorService doctorService;

	@Secured("ROLE_USER")
	@RequestMapping(value = "/addprofile", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseFormatter<RespDoctorProfileDTO> addUserProfile(
			@RequestBody RequestFormatter<ReqDoctorProfileDTO> request) throws AredviException {
		RespDoctorProfileDTO respUserProfileDTO = doctorService.addDoctorProfile(request.getRequestData());
		ResponseFormatter<RespDoctorProfileDTO> resp = new ResponseFormatter<RespDoctorProfileDTO>();
		resp.setResponseData(respUserProfileDTO);
		return resp;
	}

	@Secured("ROLE_USER")
	@RequestMapping(value = "/updateprofile", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseFormatter<RespDoctorProfileDTO> updateUserProfile(
			@RequestBody RequestFormatter<ReqDoctorProfileDTO> request) throws AredviException {
		RespDoctorProfileDTO respUserProfileDTO = doctorService.updateDoctorProfile(request.getRequestData());
		ResponseFormatter<RespDoctorProfileDTO> resp = new ResponseFormatter<RespDoctorProfileDTO>();
		resp.setResponseData(respUserProfileDTO);
		return resp;
	}

	@Secured("ROLE_USER")
	@RequestMapping(value = "/findprofile", method = RequestMethod.GET)
	public ResponseFormatter<RespDoctorProfileDTO> getUserProfile(@RequestParam UUID usrId) throws AredviException {
		RespDoctorProfileDTO respUserProfileDTO = doctorService.getDoctorProfile(usrId);
		ResponseFormatter<RespDoctorProfileDTO> resp = new ResponseFormatter<RespDoctorProfileDTO>();
		resp.setResponseData(respUserProfileDTO);
		return resp;
	}

}
