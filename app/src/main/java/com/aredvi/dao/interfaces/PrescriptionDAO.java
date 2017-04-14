package com.aredvi.dao.interfaces;

import com.aredvi.exceptions.AredviException;
import com.aredvi.sqlentity.Prescription;

public interface PrescriptionDAO {

	Prescription addPrescription(Prescription prescription) throws AredviException;

	Prescription updatePrescription(Prescription prescription) throws AredviException;

	Prescription getPrescriptionByConsultation(int consultId) throws AredviException;

	Prescription copyPrescription(int prescriptionId) throws AredviException;

}
