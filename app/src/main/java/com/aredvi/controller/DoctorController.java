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
		inventory.setFname("Doc");
		inventory.setLocp("19.1750649,73.0242481");
		
		Inventory inventory1= new Inventory();
		inventory1.setFname("Doc1");
		inventory1.setLocp("19.175489,73.0233738");
		
		Inventory inventory2= new Inventory();
		inventory2.setFname("Doc2");
		inventory2.setLocp("19.174359,73.024012");
		
		
		
		Inventory inventory3= new Inventory();
		inventory3.setFname("Doc3");
		inventory3.setLocp("1.1750649,7.0242481");
		
		Inventory inventory4= new Inventory();
		inventory4.setFname("Doc4");
		inventory4.setLocp("1.1750649,7.0242481");
		
		Inventory inventory5= new Inventory();
		inventory5.setFname("Doc5");
		inventory5.setLocp("1.1750649,3.0242481");
		
		inventorySolarService.addInventoryProfile(inventory);
		inventorySolarService.addInventoryProfile(inventory1);
		inventorySolarService.addInventoryProfile(inventory2);
		inventorySolarService.addInventoryProfile(inventory3);
		inventorySolarService.addInventoryProfile(inventory4);
		inventorySolarService.addInventoryProfile(inventory5);
		
	}
	
	@RequestMapping(value = "/searchSolr", method = RequestMethod.PUT)
	public void searchInventory() throws AredviException {
		
		
		//inventorySolarService.addInventoryProfile(inventory5);
		
	}
	
	//-------------------------------------------------------------------------------//

}
