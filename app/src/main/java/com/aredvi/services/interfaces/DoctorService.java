package com.aredvi.services.interfaces;

import java.util.UUID;

import com.aredvi.dto.request.ReqDoctorProfileDTO;
import com.aredvi.dto.response.RespDoctorProfileDTO;
import com.aredvi.exceptions.AredviException;

public interface DoctorService {
	RespDoctorProfileDTO addDoctorProfile(ReqDoctorProfileDTO requestData) throws AredviException;

	RespDoctorProfileDTO updateDoctorProfile(ReqDoctorProfileDTO requestData) throws AredviException;

	RespDoctorProfileDTO getDoctorProfile(UUID usrId) throws AredviException;

}
