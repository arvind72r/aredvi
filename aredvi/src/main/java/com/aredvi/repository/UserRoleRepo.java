package com.aredvi.repository;

import java.util.Set;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.aredvi.entity.UserRole;

public interface UserRoleRepo extends CassandraRepository<UserRole>{

	public Set<UserRole> findByUserId(String string);

}
