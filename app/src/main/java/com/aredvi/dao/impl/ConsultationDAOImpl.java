package com.aredvi.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aredvi.dao.interfaces.ConsultationDAO;
import com.aredvi.exceptions.AredviException;
import com.aredvi.mysqlrepo.ConsultationRepo;
import com.aredvi.sqlentity.Consultation;

@Repository("consultationDAO")
public class ConsultationDAOImpl implements ConsultationDAO{
	@Autowired
    private ConsultationRepo consultationRepo;

	@Override
	public Consultation addConsultation(Consultation consultation) throws AredviException {
		return consultationRepo.save(consultation);
	}

	@Override
	public Consultation updateConsultation(Consultation consultation) throws AredviException {
		return consultationRepo.save(consultation);
	}

	@Override
	public List<Consultation> getConsultationByDoctor(int docId) throws AredviException {
		return consultationRepo.findCurrentConsultation(docId);
	}

	@Override
	public List<Consultation> getConsultationByuser(int usrId) throws AredviException {
		return consultationRepo.findUserConsultation(usrId);
	}

	@Override
	public Consultation getConsultation(int consultId) throws AredviException {
		return consultationRepo.findConsultation(consultId);
	}

}
