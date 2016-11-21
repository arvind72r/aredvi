package com.aredvi.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import com.aredvi.entity.UserLogin;


public interface UserLoginRepo extends CassandraRepository<UserLogin>{

	@Query("Select * from userlogin where username=?0")
	UserLogin findByUserName(String username);

	@Query("Select * from userlogin where authid=?0")
	UserLogin findByAuthId(String authid);

}
