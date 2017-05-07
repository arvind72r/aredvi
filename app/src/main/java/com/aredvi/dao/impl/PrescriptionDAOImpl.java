package com.aredvi.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aredvi.dao.interfaces.PrescriptionDAO;
import com.aredvi.exceptions.AredviException;
import com.aredvi.sqlentity.Prescription;

@Repository("prescriptionDAO")
public class PrescriptionDAOImpl implements PrescriptionDAO{
	/*@Autowired
    private PrescriptionRepo prescriptionRepo;*/
	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public Prescription addPrescription(Prescription prescription) throws AredviException {
		return (Prescription)sessionFactory.getCurrentSession().save(prescription);
	}

	@Override
	public Prescription updatePrescription(Prescription prescription) throws AredviException {
		return (Prescription)sessionFactory.getCurrentSession().save(prescription);
	}

	@Override
	public Prescription getPrescriptionByConsultation(int consultId) throws AredviException {
		return null;
	}

	@Override
	public Prescription copyPrescription(int prescriptionId) throws AredviException {
		return null;
	}

}
