package com.aredvi.services.interfaces;

import java.util.List;

import com.aredvi.dto.request.ReqConsultationDTO;
import com.aredvi.dto.response.RespConsultationDTO;
import com.aredvi.exceptions.AredviException;

public interface ConsultationService {

	RespConsultationDTO addConsultation(ReqConsultationDTO request) throws AredviException ;

	RespConsultationDTO updateConsultation(ReqConsultationDTO request) throws AredviException ;

	RespConsultationDTO getConsultation(int consultId) throws AredviException ;

	List<RespConsultationDTO> getConsultationByDoctor(int docId)throws AredviException ;

	List<RespConsultationDTO> getConsultationByuser(int usrId) throws AredviException ;

}
