package com.aredvi.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.aredvi.repository.entity.User;


public interface UserRepo extends CassandraRepository<User> {

	User findById(UUID usrId);

	List<User> findByName(String type);

	List<User> findByType(String type);

}
