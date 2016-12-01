package com.aredvi.repository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import com.aredvi.entity.Doctor;

public interface DoctorRepo extends CassandraRepository<Doctor> {
	@Query("Select * from doctor where id=?0")
	Doctor findById(UUID usrId);
}
