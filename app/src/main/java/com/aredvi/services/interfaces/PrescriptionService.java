package com.aredvi.services.interfaces;

import com.aredvi.dto.request.RespPrescriptionDTO;
import com.aredvi.dto.response.ReqPrescriptionDTO;
import com.aredvi.exceptions.AredviException;

public interface PrescriptionService {

	RespPrescriptionDTO addPrescription(ReqPrescriptionDTO request) throws AredviException;

	RespPrescriptionDTO updatePrescription(ReqPrescriptionDTO request) throws AredviException;

	RespPrescriptionDTO getPrescriptionByConsultation(int consultId) throws AredviException;

	RespPrescriptionDTO copyPrescription(int prescriptionId) throws AredviException;

}
