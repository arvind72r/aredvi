package com.aredvi.dao.impl;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aredvi.dao.interfaces.DoctorDAO;
import com.aredvi.sqlentity.Doctor;
import com.aredvi.exceptions.AredviException;

@Repository("doctorDAO")
public class DoctorDAOImpl implements DoctorDAO{
	
	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public Doctor addDoctorProfile(Doctor doctor) throws AredviException {
		return (Doctor)sessionFactory.getCurrentSession().save(doctor);
	}

	@Override
	public Doctor updateDoctorProfile(Doctor doctor) throws AredviException {
		return (Doctor)sessionFactory.getCurrentSession().save(doctor);
	}

	@Override
	public Doctor getDoctorProfile(int usrId) throws AredviException {
		return (Doctor) sessionFactory.getCurrentSession().get(Doctor.class,usrId);
	}

}
