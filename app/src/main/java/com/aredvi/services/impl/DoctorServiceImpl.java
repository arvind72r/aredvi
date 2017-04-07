package com.aredvi.services.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aredvi.dao.interfaces.DoctorDAO;
import com.aredvi.dao.interfaces.UserDAO;
import com.aredvi.dto.request.ReqDoctorProfileDTO;
import com.aredvi.dto.response.RespDoctorProfileDTO;
import com.aredvi.exceptions.AredviException;
import com.aredvi.services.interfaces.DoctorService;
import com.aredvi.sqlentity.Doctor;
import com.aredvi.sqlentity.User;

@Service("doctorService")
public class DoctorServiceImpl implements DoctorService {

	@Resource(name = "doctorDAO")
	private DoctorDAO doctorDAO;
	
	@Resource(name = "userDAO")
	private UserDAO userDAO;
	

	@Override
	public RespDoctorProfileDTO addDoctorProfile(ReqDoctorProfileDTO requestData) throws AredviException {
		RespDoctorProfileDTO respDoctorProfileDTO = new RespDoctorProfileDTO();
		User user = userDAO.getUserProfile(requestData.getUserId());
		Doctor doctor = convertRequestToEntity(requestData);
		doctor = doctorDAO.addDoctorProfile(doctor);
		respDoctorProfileDTO = convertEntityToResponse(doctor);	
		return respDoctorProfileDTO;
	}

	@Override
	public RespDoctorProfileDTO updateDoctorProfile(ReqDoctorProfileDTO requestData) throws AredviException {
		RespDoctorProfileDTO respDoctorProfileDTO = new RespDoctorProfileDTO();
		Doctor doctor = convertRequestToEntity(requestData);
		doctor = doctorDAO.updateDoctorProfile(doctor);
		respDoctorProfileDTO = convertEntityToResponse(doctor);
		return respDoctorProfileDTO;
	}

	@Override
	public RespDoctorProfileDTO getDoctorProfile(int usrId) throws AredviException {
		RespDoctorProfileDTO respDoctorProfileDTO = new RespDoctorProfileDTO();
		Doctor doctor = doctorDAO.getDoctorProfile(usrId);
		respDoctorProfileDTO = convertEntityToResponse(doctor);
		return respDoctorProfileDTO;
	}


	public Doctor convertRequestToEntity(ReqDoctorProfileDTO requestData) throws AredviException {
		Doctor doctor = new Doctor();
		swapData(doctor,requestData);
		return doctor;
	}

	public RespDoctorProfileDTO convertEntityToResponse(Doctor doctor) throws AredviException {
		RespDoctorProfileDTO respDoctorProfileDTO = new RespDoctorProfileDTO();
		swapData(respDoctorProfileDTO,doctor);
		return respDoctorProfileDTO;
	}
	

	public void swapData(Doctor doctor,ReqDoctorProfileDTO requestData){
		if(null != requestData){
			doctor.setCalendar(requestData.getCalendar());
			doctor.setMpLicAuthority(requestData.getMpLicAuthority());
			doctor.setMpLicDateOfIssue(requestData.getMpLicDateOfIssue());
			doctor.setMpLicNo(requestData.getMpLicNo());
			doctor.setPhoto(requestData.getPhoto());
			doctor.setProfile(requestData.getProfile());
			doctor.setVarified(requestData.isVarified());
			doctor.setProfileDelted(requestData.isProfileDelted());
		}
	}
	
	public void swapData(RespDoctorProfileDTO respData, Doctor doctor){
		if(null != doctor){
			respData.setCalendar(doctor.getCalendar());
			respData.setMpLicAuthority(doctor.getMpLicAuthority());
			respData.setMpLicDateOfIssue(doctor.getMpLicDateOfIssue());
			respData.setMpLicNo(doctor.getMpLicNo());
			respData.setPhoto(doctor.getPhoto());
			respData.setProfile(doctor.getProfile());
			respData.setVarified(doctor.isVarified());
			respData.setProfileDelted(doctor.isProfileDelted());
		}
	}
	
}
