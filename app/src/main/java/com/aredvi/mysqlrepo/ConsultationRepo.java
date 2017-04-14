package com.aredvi.mysqlrepo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aredvi.sqlentity.Consultation;

public interface ConsultationRepo extends CrudRepository<Consultation,Integer>{

	List<Consultation> findCurrentConsultation(int docId);

	List<Consultation> findUserConsultation(int usrId);

	Consultation findConsultation(int consultId);

}
