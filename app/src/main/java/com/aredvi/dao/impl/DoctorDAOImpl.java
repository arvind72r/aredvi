package com.aredvi.dao.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aredvi.dao.interfaces.DoctorDAO;
import com.aredvi.entity.Doctor;
import com.aredvi.exceptions.AredviException;
import com.aredvi.repository.DoctorRepo;

@Repository("doctorDAO")
public class DoctorDAOImpl implements DoctorDAO{
	
	@Autowired
	DoctorRepo doctorRepo;

	@Override
	public Doctor addDoctorProfile(Doctor doctor) throws AredviException {
		return doctorRepo.save(doctor);
	}

	@Override
	public Doctor updateDoctorProfile(Doctor doctor) throws AredviException {
		return doctorRepo.save(doctor);
	}

	@Override
	public Doctor getDoctorProfile(UUID usrId) throws AredviException {
		return doctorRepo.findById(usrId);
	}

	@Override
	public List<Doctor> searchDoctorByType(String name) throws AredviException {
		return null;
	}

	@Override
	public List<Doctor> searchDoctorByName(String name) throws AredviException {
		return null;
	}

}
