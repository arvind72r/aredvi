package com.aredvi.services.impl;

import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aredvi.dao.interfaces.DoctorDAO;
import com.aredvi.dao.interfaces.InventoryDAO;
import com.aredvi.dao.interfaces.UserDAO;
import com.aredvi.dto.request.ReqDoctorProfileDTO;
import com.aredvi.dto.response.RespDoctorProfileDTO;
import com.aredvi.entity.Doctor;
import com.aredvi.entity.Inventory;
import com.aredvi.entity.User;
import com.aredvi.exceptions.AredviException;
import com.aredvi.services.interfaces.DoctorService;

@Service("doctorService")
public class DoctorServiceImpl implements DoctorService {

	@Resource(name = "doctorDAO")
	private DoctorDAO doctorDAO;
	
	@Resource(name = "userDAO")
	private UserDAO userDAO;
	
	@Resource(name="inventoryDAO")
	private InventoryDAO inventoryDAO;

	@Override
	public RespDoctorProfileDTO addDoctorProfile(ReqDoctorProfileDTO requestData) throws AredviException {
		RespDoctorProfileDTO respDoctorProfileDTO = new RespDoctorProfileDTO();
		User user = userDAO.getUserProfile(requestData.getUserId());
		Doctor doctor = convertRequestToEntity(requestData);
		convertUserToDoctor(user,doctor);
		doctor = doctorDAO.addDoctorProfile(doctor);
		respDoctorProfileDTO = convertEntityToResponse(doctor);	
		Inventory inventory = convertRequestToInventory(requestData,doctor);
		inventoryDAO.addInventory(inventory);
		return respDoctorProfileDTO;
	}

	@Override
	public RespDoctorProfileDTO updateDoctorProfile(ReqDoctorProfileDTO requestData) throws AredviException {
		RespDoctorProfileDTO respDoctorProfileDTO = new RespDoctorProfileDTO();
		Doctor doctor = convertRequestToEntity(requestData);
		doctor = doctorDAO.updateDoctorProfile(doctor);
		respDoctorProfileDTO = convertEntityToResponse(doctor);
		Inventory inventory = convertRequestToInventory(requestData,doctor);
		inventoryDAO.updateInventory(inventory);
		return respDoctorProfileDTO;
	}

	@Override
	public RespDoctorProfileDTO getDoctorProfile(UUID usrId) throws AredviException {
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
	
	public Inventory convertRequestToInventory(ReqDoctorProfileDTO requestData, Doctor doctor) throws AredviException {
		Inventory inventory = new Inventory();
		swapData(inventory,requestData,doctor);
		return inventory;
	}

	public void swapData(Inventory inventory, ReqDoctorProfileDTO requestData,Doctor doctor){
		inventory.setAddress(requestData.getAddress());
		inventory.setCity(requestData.getCity());
		inventory.setFullname(requestData.getFname()+requestData.getLname());
		inventory.setGoogleId(requestData.getGoogleId());
		inventory.setId(doctor.getId());
		inventory.setLat(doctor.getLat());
		inventory.setLongs(doctor.getLongs());
		inventory.setMobile(doctor.getMobileNumber());
		String phone = "";
		if(null != doctor.getPhoneNumber()){
			for(String ph : doctor.getPhoneNumber()){
				phone = phone +","+ph;
			}
		}
		inventory.setPhone(phone);
		inventory.setPlaceId(requestData.getPlaceId());
		inventory.setProfileDelted(doctor.isProfileDelted());
		inventory.setProfile(requestData.getProfile());
		inventory.setSolarId(doctor.getId().toString());
		String specialities = "";
		if(null != doctor.getPhoneNumber()){
			for(String speciality : doctor.getPhoneNumber()){
				specialities = specialities +","+speciality;
			}
		}
		inventory.setSpecialities(specialities);
		inventory.setType("DOCTOR");
		inventory.setVarified(doctor.isVarified());
	}
	
	public void swapData(Doctor doctor,ReqDoctorProfileDTO requestData){
		if(null != requestData){
			doctor.setCalendar(requestData.getCalendar());
			doctor.setDob(requestData.getDob());
			doctor.setDocuments(requestData.getDocuments());
			doctor.setEmail(requestData.getEmail());
			doctor.setFname(requestData.getFname());
			doctor.setGender(requestData.getGender());
			doctor.setId(requestData.getId());
			doctor.setLname(requestData.getLname());
			doctor.setMobileNumber(requestData.getMobileNumber());
			doctor.setMpLicAuthority(requestData.getMpLicAuthority());
			doctor.setMpLicDateOfIssue(requestData.getMpLicDateOfIssue());
			doctor.setMpLicNo(requestData.getMpLicNo());
			doctor.setPhoto(requestData.getPhoto());
			doctor.setProfile(requestData.getProfile());
			doctor.setSpecialities(requestData.getSpecialities());
			doctor.setVarified(requestData.isVarified());
			doctor.setProfileDelted(requestData.isProfileDelted());
			doctor.setPhoneNumber(requestData.getPhoneNumber());
			doctor.setLat(requestData.getLat());
			doctor.setLongs(requestData.getLongs());
			doctor.setCity(requestData.getCity());
		}
	}
	
	public void swapData(RespDoctorProfileDTO respData, Doctor doctor){
		if(null != doctor){
			respData.setCalendar(doctor.getCalendar());
			respData.setDob(doctor.getDob());
			respData.setDocuments(doctor.getDocuments());
			respData.setEmail(doctor.getEmail());
			respData.setFname(doctor.getFname());
			respData.setGender(doctor.getGender());
			respData.setId(doctor.getId());
			respData.setLname(doctor.getLname());
			respData.setMobileNumber(doctor.getMobileNumber());
			respData.setMpLicAuthority(doctor.getMpLicAuthority());
			respData.setMpLicDateOfIssue(doctor.getMpLicDateOfIssue());
			respData.setMpLicNo(doctor.getMpLicNo());
			respData.setPhoto(doctor.getPhoto());
			respData.setProfile(doctor.getProfile());
			respData.setSpecialities(doctor.getSpecialities());
			respData.setVarified(doctor.isVarified());
			respData.setProfileDelted(doctor.isProfileDelted());
			respData.setPhoneNumber(doctor.getPhoneNumber());
			respData.setLat(doctor.getLat());
			respData.setLongs(doctor.getLongs());
			respData.setCity(doctor.getCity());
		}
	}
	
	private void convertUserToDoctor(User user, Doctor doctor) {
		doctor.setId(user.getId());
		doctor.setEmail(user.getEmail());
		doctor.setFname(user.getFname());
		doctor.setGender(user.getGender());
		doctor.setLname(user.getLname());
	}
}
