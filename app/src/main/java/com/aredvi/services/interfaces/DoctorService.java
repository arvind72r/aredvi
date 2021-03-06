package com.aredvi.services.interfaces;

import com.aredvi.dto.request.ReqDoctorProfileDTO;
import com.aredvi.dto.response.RespDoctorProfileDTO;
import com.aredvi.exceptions.AredviException;

public interface DoctorService {
	RespDoctorProfileDTO addDoctorProfile(ReqDoctorProfileDTO requestData) throws AredviException;

	RespDoctorProfileDTO updateDoctorProfile(ReqDoctorProfileDTO requestData) throws AredviException;

	RespDoctorProfileDTO getDoctorProfile(int usrId) throws AredviException;

}
