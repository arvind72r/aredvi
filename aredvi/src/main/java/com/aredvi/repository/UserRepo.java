package com.aredvi.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.aredvi.entity.User;

public interface UserRepo extends CassandraRepository<User> {

	User findById(String usrId);

	List<User> findByName(String type);

	List<User> findByType(String type);

}
