package com.aredvi.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aredvi.dao.interfaces.ConsultationDAO;
import com.aredvi.dto.request.ReqConsultationDTO;
import com.aredvi.dto.response.RespConsultationDTO;
import com.aredvi.exceptions.AredviException;
import com.aredvi.services.interfaces.ConsultationService;
import com.aredvi.sqlentity.Consultation;

@Service("consultationService")
public class ConsultationServiceImpl implements ConsultationService{
	
	@Resource(name = "consultationDAO")
	private ConsultationDAO consultationDAO;
	
	@Override
	public RespConsultationDTO addConsultation(ReqConsultationDTO request) throws AredviException {
		RespConsultationDTO respConsultationDTO = new RespConsultationDTO();
		Consultation consultation = new Consultation();
		convertRequestToEntity(request,consultation);
		consultationDAO.addConsultation(consultation);
		convertEntityToResponse(consultation,respConsultationDTO);
		return respConsultationDTO;
	}

	@Override
	public RespConsultationDTO updateConsultation(ReqConsultationDTO request) throws AredviException {
		RespConsultationDTO respConsultationDTO = new RespConsultationDTO();
		Consultation consultation = new Consultation();
		convertRequestToEntity(request,consultation);
		consultationDAO.updateConsultation(consultation);
		convertEntityToResponse(consultation,respConsultationDTO);
		return respConsultationDTO;
	}

	@Override
	public RespConsultationDTO getConsultation(int consultId) throws AredviException {
		Consultation consultation =  consultationDAO.getConsultation(consultId);
		RespConsultationDTO respConsultationDTO = new RespConsultationDTO();
		convertEntityToResponse(consultation,respConsultationDTO);
		return respConsultationDTO;
	}

	@Override
	public List<RespConsultationDTO> getConsultationByDoctor(int docId) throws AredviException {
		List<Consultation> consultations = consultationDAO.getConsultationByDoctor(docId);
		List<RespConsultationDTO> respConsultationDTOs = new ArrayList<RespConsultationDTO>();
		for(Consultation consultation : consultations){
			RespConsultationDTO respConsultationDTO = new RespConsultationDTO();
			convertEntityToResponse(consultation,respConsultationDTO);
			respConsultationDTOs.add(respConsultationDTO);
		}
		return respConsultationDTOs;
	}

	@Override
	public List<RespConsultationDTO> getConsultationByuser(int usrId) throws AredviException {
		List<Consultation> consultations = consultationDAO.getConsultationByuser(usrId);
		List<RespConsultationDTO> respConsultationDTOs = new ArrayList<RespConsultationDTO>();
		for(Consultation consultation : consultations){
			RespConsultationDTO respConsultationDTO = new RespConsultationDTO();
			convertEntityToResponse(consultation,respConsultationDTO);
			respConsultationDTOs.add(respConsultationDTO);
		}
		return respConsultationDTOs;
	}

	private void convertRequestToEntity(ReqConsultationDTO request, Consultation consultation) {
		
	}
	
	private void convertEntityToResponse(Consultation consultation, RespConsultationDTO respConsultationDTO) {
		
	}


}
