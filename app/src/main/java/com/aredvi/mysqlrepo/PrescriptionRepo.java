package com.aredvi.mysqlrepo;

import org.springframework.data.repository.CrudRepository;

import com.aredvi.sqlentity.Prescription;

public interface PrescriptionRepo extends CrudRepository<Prescription,Integer>{

	Prescription getPrescriptionByConsultation(int consultId);

	Prescription copyPrescription(int prescriptionId);

}
