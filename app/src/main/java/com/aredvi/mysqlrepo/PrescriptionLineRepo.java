package com.aredvi.mysqlrepo;

import org.springframework.data.repository.CrudRepository;

import com.aredvi.sqlentity.Prescription;

public interface PrescriptionLineRepo extends CrudRepository<Prescription,Integer>{

}
