package com.aredvi.repository;

import java.util.Set;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.aredvi.repository.entity.UserRole;


public interface UserRoleRepo extends CassandraRepository<UserRole>{

	public Set<UserRole> findByUserId(UUID id);

}
