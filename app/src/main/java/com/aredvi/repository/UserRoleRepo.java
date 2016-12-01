package com.aredvi.repository;

import java.util.Set;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import com.aredvi.entity.UserRole;


public interface UserRoleRepo extends CassandraRepository<UserRole>{

	@Query("Select * from userrole where user_id=?0 ALLOW FILTERING")
	public Set<UserRole> findByUserId(UUID id);

}
