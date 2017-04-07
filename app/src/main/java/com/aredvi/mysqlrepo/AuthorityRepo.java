package com.aredvi.mysqlrepo;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import com.aredvi.entity.Authority;


public interface AuthorityRepo extends CassandraRepository<Authority> {

	Authority finByRole(String role);

}
