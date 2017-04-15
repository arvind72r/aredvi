package com.aredvi.services.interfaces;

import com.aredvi.dto.request.ReqPrescriptionDTO;
import com.aredvi.dto.response.RespPrescriptionDTO;
import com.aredvi.exceptions.AredviException;

public interface PrescriptionService {

	RespPrescriptionDTO addPrescription(ReqPrescriptionDTO request) throws AredviException;

	RespPrescriptionDTO updatePrescription(ReqPrescriptionDTO request) throws AredviException;

	RespPrescriptionDTO getPrescriptionByConsultation(int consultId) throws AredviException;

	RespPrescriptionDTO copyPrescription(int prescriptionId) throws AredviException;

}
