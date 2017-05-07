package com.aredvi.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aredvi.dao.interfaces.ConsultationDAO;
import com.aredvi.exceptions.AredviException;
import com.aredvi.sqlentity.Authority;
import com.aredvi.sqlentity.Consultation;

@Repository("consultationDAO")
public class ConsultationDAOImpl implements ConsultationDAO{
	//@Autowired
   // private ConsultationRepo consultationRepo;
	
	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public Consultation addConsultation(Consultation consultation) throws AredviException {
		sessionFactory.getCurrentSession().save(consultation);
		return consultation;
	}

	@Override
	public Consultation updateConsultation(Consultation consultation) throws AredviException {
		sessionFactory.getCurrentSession().save(consultation);
		return consultation;
	}

	@Override
	public List<Consultation> getConsultationByDoctor(int docId) throws AredviException {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Consultation.class);
		cr.add(Restrictions.eq("doctor.docID", docId));
		List<Consultation> lconsult = cr.list();
		return lconsult;
	}

	@Override
	public List<Consultation> getConsultationByuser(int usrId) throws AredviException {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Consultation.class);
		cr.add(Restrictions.eq("user.userId", usrId));
		List<Consultation> lconsult = cr.list();
		return lconsult;
	}

	@Override
	public Consultation getConsultation(int consultId) throws AredviException {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Consultation.class);
		cr.add(Restrictions.eq("consultationId", consultId));
		List<Consultation> lconsult = cr.list();
		Consultation consult = new Consultation();
		if(lconsult!=null && lconsult.size()>0){
			consult = (Consultation) lconsult.get(0);
		}else{
			consult = null;
		}
		return consult;
	}

}
