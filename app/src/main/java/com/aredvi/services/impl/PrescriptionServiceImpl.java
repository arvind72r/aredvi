package com.aredvi.services.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aredvi.dao.interfaces.PrescriptionDAO;
import com.aredvi.dto.request.ReqPrescriptionDTO;
import com.aredvi.dto.response.RespPrescriptionDTO;
import com.aredvi.exceptions.AredviException;
import com.aredvi.services.interfaces.PrescriptionService;
import com.aredvi.sqlentity.Prescription;

@Service("prescriptionService")
public class PrescriptionServiceImpl implements PrescriptionService{
	
	@Resource(name = "prescriptionDAO")
	private PrescriptionDAO prescriptionDAO;

	@Override
	public RespPrescriptionDTO addPrescription(ReqPrescriptionDTO request) throws AredviException {
		RespPrescriptionDTO respPrescriptionDTO = new RespPrescriptionDTO();
		Prescription prescription = new Prescription();
		convertRequestToEntity(request,prescription);
		prescription = prescriptionDAO.addPrescription(prescription);
		convertEntityToResponse(prescription,respPrescriptionDTO);
		return respPrescriptionDTO;
	}

	@Override
	public RespPrescriptionDTO updatePrescription(ReqPrescriptionDTO request) throws AredviException {
		RespPrescriptionDTO respPrescriptionDTO = new RespPrescriptionDTO();
		Prescription prescription = new Prescription();
		convertRequestToEntity(request,prescription);
		prescription = prescriptionDAO.updatePrescription(prescription);
		convertEntityToResponse(prescription,respPrescriptionDTO);
		return respPrescriptionDTO;
	}

	@Override
	public RespPrescriptionDTO getPrescriptionByConsultation(int consultId) throws AredviException {
		RespPrescriptionDTO respPrescriptionDTO = new RespPrescriptionDTO();
		Prescription prescription = prescriptionDAO.getPrescriptionByConsultation(consultId);
		convertEntityToResponse(prescription,respPrescriptionDTO);
		return respPrescriptionDTO;
	}

	@Override
	public RespPrescriptionDTO copyPrescription(int prescriptionId) throws AredviException {
		RespPrescriptionDTO respPrescriptionDTO = new RespPrescriptionDTO();
		Prescription prescription = prescriptionDAO.copyPrescription(prescriptionId);
		convertEntityToResponse(prescription,respPrescriptionDTO);
		return respPrescriptionDTO;
	}

	private void convertRequestToEntity(ReqPrescriptionDTO request, Prescription prescription) {
		
	}
	
	private void convertEntityToResponse(Prescription prescription, RespPrescriptionDTO respPrescriptionDTO) {
		
	}
}
