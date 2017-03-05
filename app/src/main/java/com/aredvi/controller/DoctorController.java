package com.aredvi.controller;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aredvi.dto.request.ReqDoctorProfileDTO;
import com.aredvi.dto.response.RespDoctorProfileDTO;
import com.aredvi.entity.Doctor;
import com.aredvi.exceptions.AredviException;
import com.aredvi.repository.DoctorRepo;
import com.aredvi.services.interfaces.DoctorService;
import com.aredvi.services.interfaces.InventorySolarService;
import com.aredvi.solr.Inventory;
import com.aredvi.utils.ResponseFormatter;

@RestController
@RequestMapping(value = "/doctor")
public class DoctorController {

	@Resource(name = "doctorService")
	private DoctorService doctorService;
	
	@Resource(name="inventorySolarService")
	private InventorySolarService inventorySolarService;
	
	@Autowired
	DoctorRepo doctorRepo;

	@RequestMapping(value = "/addprofile", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseFormatter<RespDoctorProfileDTO> addDoctorProfile(
			@RequestBody ReqDoctorProfileDTO request) throws AredviException {
		RespDoctorProfileDTO respUserProfileDTO = doctorService.addDoctorProfile(request);
		ResponseFormatter<RespDoctorProfileDTO> resp = new ResponseFormatter<RespDoctorProfileDTO>();
		resp.setResponseData(respUserProfileDTO);
		return resp;
	}

	@Secured("ROLE_USER")
	@RequestMapping(value = "/updateprofile", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseFormatter<RespDoctorProfileDTO> updateDoctorProfile(
			@RequestBody ReqDoctorProfileDTO request) throws AredviException {
		RespDoctorProfileDTO respUserProfileDTO = doctorService.updateDoctorProfile(request);
		ResponseFormatter<RespDoctorProfileDTO> resp = new ResponseFormatter<RespDoctorProfileDTO>();
		resp.setResponseData(respUserProfileDTO);
		return resp;
	}

	@Secured("ROLE_USER")
	@RequestMapping(value = "/findprofile", method = RequestMethod.GET)
	public ResponseFormatter<RespDoctorProfileDTO> getDoctorProfile(@RequestParam UUID usrId) throws AredviException {
		RespDoctorProfileDTO respUserProfileDTO = doctorService.getDoctorProfile(usrId);
		ResponseFormatter<RespDoctorProfileDTO> resp = new ResponseFormatter<RespDoctorProfileDTO>();
		resp.setResponseData(respUserProfileDTO);
		return resp;
	}
	
	@RequestMapping(value = "/findbyfname", method = RequestMethod.GET)
	public ResponseFormatter<List<Doctor>> findByFname(@RequestParam String fname) throws AredviException {
		List<Doctor> doctors = doctorRepo.findByFName(fname);
		ResponseFormatter<List<Doctor>> resp = new ResponseFormatter<List<Doctor>>();
		resp.setResponseData(doctors);
		return resp;
	}
	
	@RequestMapping(value = "/findbylname", method = RequestMethod.GET)
	public ResponseFormatter<List<Doctor>> findByLname(@RequestParam String lname) throws AredviException {
		List<Doctor> doctors = doctorRepo.findByFName(lname);
		ResponseFormatter<List<Doctor>> resp = new ResponseFormatter<List<Doctor>>();
		resp.setResponseData(doctors);
		return resp;
	}
	
	@RequestMapping(value = "/addInventorySolr", method = RequestMethod.PUT)
	public void addInventory() throws AredviException {
		
		Inventory inventory= new Inventory();
		inventory.setFname("VisHnu BHAgat");
		
		inventorySolarService.addInventoryProfile(inventory);
		
	}
	
	@RequestMapping(value = "/searchSolr", method = RequestMethod.PUT)
	public void searchInventory() throws AredviException {
		
		Inventory inventory= new Inventory();
		inventory.setFname("VisHnu BHAgat");
		
		inventorySolarService.addInventoryProfile(inventory);
		
	}
	
	//-------------------------------------------------------------------------------//

}
