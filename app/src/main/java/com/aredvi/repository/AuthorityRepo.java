package com.aredvi.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import com.aredvi.entity.Authority;


public interface AuthorityRepo extends CassandraRepository<Authority> {

	@Query("Select * from authority where role=?0")
	Authority finByRole(String role);

}
