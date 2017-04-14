package com.aredvi.mysqlrepo;

import org.springframework.data.repository.CrudRepository;

import com.aredvi.sqlentity.Doctor;

public interface DoctorRepo extends CrudRepository<Doctor,Integer>{

	Doctor findByDocID(int usrId);

}
