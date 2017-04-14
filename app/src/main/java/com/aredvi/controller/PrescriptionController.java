package com.aredvi.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aredvi.dto.request.RespPrescriptionDTO;
import com.aredvi.dto.response.ReqPrescriptionDTO;
import com.aredvi.exceptions.AredviException;
import com.aredvi.services.interfaces.PrescriptionService;
import com.aredvi.utils.ResponseFormatter;

@RestController
@RequestMapping(value = "/prescription")
public class PrescriptionController {
	
	@Resource(name = "prescriptionService")
	PrescriptionService prescriptionService;
	
	@RequestMapping(value = "/add", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseFormatter<RespPrescriptionDTO> addPrescription(@RequestBody ReqPrescriptionDTO request) throws AredviException{
		RespPrescriptionDTO respPrescriptionDTO = prescriptionService.addPrescription(request);
		ResponseFormatter<RespPrescriptionDTO> resp = new ResponseFormatter<RespPrescriptionDTO>();
		resp.setResponseData(respPrescriptionDTO);
		return resp;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseFormatter<RespPrescriptionDTO> updatePrescription(@RequestBody ReqPrescriptionDTO request) throws AredviException{
		RespPrescriptionDTO respPrescriptionDTO = prescriptionService.updatePrescription(request);
		ResponseFormatter<RespPrescriptionDTO> resp = new ResponseFormatter<RespPrescriptionDTO>();
		resp.setResponseData(respPrescriptionDTO);
		return resp;
	}
	
	@RequestMapping(value = "/getbyconsultation", method = RequestMethod.GET)
	public ResponseFormatter<RespPrescriptionDTO> getPrescriptionByConsultation(@RequestParam int consultId) throws AredviException{
		RespPrescriptionDTO respPrescriptionDTO = prescriptionService.getPrescriptionByConsultation(consultId);
		ResponseFormatter<RespPrescriptionDTO> resp = new ResponseFormatter<RespPrescriptionDTO>();
		resp.setResponseData(respPrescriptionDTO);
		return resp;
	}
	
	@RequestMapping(value = "/copyprescription", method = RequestMethod.GET)
	public ResponseFormatter<RespPrescriptionDTO> copyPrescription(@RequestParam int prescriptionId) throws AredviException{
		RespPrescriptionDTO respPrescriptionDTO = prescriptionService.copyPrescription(prescriptionId);
		ResponseFormatter<RespPrescriptionDTO> resp = new ResponseFormatter<RespPrescriptionDTO>();
		resp.setResponseData(respPrescriptionDTO);
		return resp;
	}
}
