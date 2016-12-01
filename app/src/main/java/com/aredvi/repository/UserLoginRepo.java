package com.aredvi.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import com.aredvi.entity.UserLogin;


public interface UserLoginRepo extends CassandraRepository<UserLogin>{

	@Query("Select * from userlogin where user_name=?0 ALLOW FILTERING")
	UserLogin findByUserName(String username);

	@Query("Select * from userlogin where auth_id=?0")
	UserLogin findByAuthId(String authid);

}
