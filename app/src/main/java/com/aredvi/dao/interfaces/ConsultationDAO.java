package com.aredvi.dao.interfaces;

import java.util.List;

import com.aredvi.exceptions.AredviException;
import com.aredvi.sqlentity.Consultation;

public interface ConsultationDAO {

	Consultation addConsultation(Consultation consultation) throws AredviException;

	Consultation updateConsultation(Consultation consultation)  throws AredviException;

	List<Consultation> getConsultationByDoctor(int docId) throws AredviException;

	List<Consultation> getConsultationByuser(int usrId) throws AredviException;

	Consultation getConsultation(int usrId) throws AredviException;

}
