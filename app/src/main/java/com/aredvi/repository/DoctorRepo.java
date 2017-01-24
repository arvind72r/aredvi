package com.aredvi.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import com.aredvi.entity.Doctor;

public interface DoctorRepo extends CassandraRepository<Doctor> {
	@Query("Select * from doctor where id=?0")
	Doctor findById(UUID usrId);
	
	@Query("Select * from doctor where f_name=?0")
	List<Doctor> findByFName(String fName);
	
	@Query("Select * from doctor where l_name=?0")
	List<Doctor> findByLName(String lName);
}
