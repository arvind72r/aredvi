package com.aredvi.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.aredvi.repository.entity.UserLogin;


public interface UserLoginRepo extends CassandraRepository<UserLogin>{

	UserLogin findByUserName(String username);

	UserLogin findByAuthId(String authid);

}
