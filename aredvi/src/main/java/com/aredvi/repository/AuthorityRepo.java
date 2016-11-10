package com.aredvi.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.aredvi.entity.Authority;

public interface AuthorityRepo extends CassandraRepository<Authority>{

	Authority finByRole(String role);

}
