package com.aredvi.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aredvi.dao.interfaces.PrescriptionDAO;
import com.aredvi.exceptions.AredviException;
import com.aredvi.mysqlrepo.PrescriptionRepo;
import com.aredvi.sqlentity.Prescription;

@Repository("prescriptionDAO")
public class PrescriptionDAOImpl implements PrescriptionDAO{
	@Autowired
    private PrescriptionRepo prescriptionRepo;

	@Override
	public Prescription addPrescription(Prescription prescription) throws AredviException {
		return prescriptionRepo.save(prescription);
	}

	@Override
	public Prescription updatePrescription(Prescription prescription) throws AredviException {
		return prescriptionRepo.save(prescription);
	}

	@Override
	public Prescription getPrescriptionByConsultation(int consultId) throws AredviException {
		return prescriptionRepo.getPrescriptionByConsultation(consultId);
	}

	@Override
	public Prescription copyPrescription(int prescriptionId) throws AredviException {
		return prescriptionRepo.copyPrescription(prescriptionId);
	}

}
