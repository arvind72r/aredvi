package com.aredvi.dao.impl;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Parent;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aredvi.dao.interfaces.DoctorDAO;
import com.aredvi.exceptions.AredviException;
import com.aredvi.sqlentity.Consultation;
import com.aredvi.sqlentity.Doctor;
import com.aredvi.sqlentity.User;

@Repository("doctorDAO")
public class DoctorDAOImpl implements DoctorDAO{
	
	/*@Autowired
    private DoctorRepo doctorRepo;*/
	
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
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Doctor.class);
		cr.add(Restrictions.eq("user.userId",new Integer(usrId)));
		List<Doctor> lDoctor = cr.list();
		Doctor doc = new Doctor();
		if(lDoctor!=null && lDoctor.size()>0){
			doc = (Doctor) lDoctor.get(0);
		}else{
			doc = null;
		}
		return doc;
	}

}
