package com.aredvi.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aredvi.dto.request.ReqConsultationDTO;
import com.aredvi.dto.response.RespConsultationDTO;
import com.aredvi.exceptions.AredviException;
import com.aredvi.services.interfaces.ConsultationService;
import com.aredvi.utils.ResponseFormatter;

@RestController
@RequestMapping(value = "/consultation")
public class ConsultationController {
	
	@Resource(name = "consultationService")
	private ConsultationService consultationService;
	
	@RequestMapping(value = "/addconsultation", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseFormatter<RespConsultationDTO> addConsultation(@RequestBody ReqConsultationDTO request) throws AredviException{
		RespConsultationDTO respConsultationDTO = consultationService.addConsultation(request);
		ResponseFormatter<RespConsultationDTO> resp = new ResponseFormatter<RespConsultationDTO>();
		resp.setResponseData(respConsultationDTO);
		return resp;
	}
	
	@RequestMapping(value = "/updateconsultation", method = RequestMethod.PUT, headers = "Accept=application/json")
	public ResponseFormatter<RespConsultationDTO> updateConsultation(@RequestBody ReqConsultationDTO request) throws AredviException{
		RespConsultationDTO respConsultationDTO = consultationService.updateConsultation(request);
		ResponseFormatter<RespConsultationDTO> resp = new ResponseFormatter<RespConsultationDTO>();
		resp.setResponseData(respConsultationDTO);
		return resp;
	}
	
	@RequestMapping(value = "/getconsultation", method = RequestMethod.GET)
	public ResponseFormatter<RespConsultationDTO> getConsultation(@RequestParam int consultId) throws AredviException{
		RespConsultationDTO respConsultationDTO = consultationService.getConsultation(consultId);
		ResponseFormatter<RespConsultationDTO> resp = new ResponseFormatter<RespConsultationDTO>();
		resp.setResponseData(respConsultationDTO);
		return resp;
	}
	
	@RequestMapping(value = "/getconsultationbydoctor", method = RequestMethod.GET)
	public ResponseFormatter<List<RespConsultationDTO>> getConsultationByDoctor(@RequestParam int docId) throws AredviException{
		List<RespConsultationDTO> respConsultationDTO = consultationService.getConsultationByDoctor(docId);
		ResponseFormatter<List<RespConsultationDTO>> resp = new ResponseFormatter<List<RespConsultationDTO>>();
		resp.setResponseData(respConsultationDTO);
		return resp;
	}
	
	@RequestMapping(value = "/getconsultationbyuser", method = RequestMethod.GET)
	public ResponseFormatter<List<RespConsultationDTO>> getConsultationByuser(@RequestParam int usrId) throws AredviException{
		List<RespConsultationDTO> respConsultationDTO = consultationService.getConsultationByuser(usrId);
		ResponseFormatter<List<RespConsultationDTO>> resp = new ResponseFormatter<List<RespConsultationDTO>>();
		resp.setResponseData(respConsultationDTO);
		return resp;
	}
}
