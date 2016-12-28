package com.aredvi.dao.interfaces;

import java.util.UUID;

import com.aredvi.entity.Doctor;
import com.aredvi.exceptions.AredviException;

public interface DoctorDAO {
	Doctor addDoctorProfile(Doctor doctor) throws AredviException;

	Doctor updateDoctorProfile(Doctor doctor) throws AredviException;

	Doctor getDoctorProfile(UUID usrId) throws AredviException;
}
