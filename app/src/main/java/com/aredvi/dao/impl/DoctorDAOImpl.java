package com.aredvi.dao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aredvi.dao.interfaces.DoctorDAO;
import com.aredvi.exceptions.AredviException;
import com.aredvi.mysqlrepo.DoctorRepo;
import com.aredvi.sqlentity.Doctor;

@Repository("doctorDAO")
public class DoctorDAOImpl implements DoctorDAO{
	
	@Autowired
    private DoctorRepo doctorRepo;

	@Override
	public Doctor addDoctorProfile(Doctor doctor) throws AredviException {
		return doctorRepo.save(doctor);
	}

	@Override
	public Doctor updateDoctorProfile(Doctor doctor) throws AredviException {
		return doctorRepo.save(doctor);
	}

	@Override
	public Doctor getDoctorProfile(int usrId) throws AredviException {
		return doctorRepo.findByDocID(usrId);
	}

}
