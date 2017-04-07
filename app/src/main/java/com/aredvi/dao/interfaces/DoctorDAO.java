package com.aredvi.dao.interfaces;

import com.aredvi.sqlentity.Doctor;
import com.aredvi.exceptions.AredviException;

public interface DoctorDAO {
	Doctor addDoctorProfile(Doctor doctor) throws AredviException;

	Doctor updateDoctorProfile(Doctor doctor) throws AredviException;

	Doctor getDoctorProfile(int usrId) throws AredviException;
}
