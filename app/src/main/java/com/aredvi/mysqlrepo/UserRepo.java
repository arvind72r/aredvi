package com.aredvi.mysqlrepo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import com.aredvi.entity.User;


public interface UserRepo extends CassandraRepository<User> {
	
	@Query("Select * from user where id=?0")
	User findById(UUID usrId);

	@Query("Select * from user where name=?0")
	List<User> findByName(String type);

	@Query("Select * from user where type=?0")
	List<User> findByType(String type);

}
