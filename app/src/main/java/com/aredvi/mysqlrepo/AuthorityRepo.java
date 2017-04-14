package com.aredvi.mysqlrepo;

import org.springframework.data.repository.CrudRepository;

import com.aredvi.sqlentity.Authority;


public interface AuthorityRepo extends CrudRepository<Authority,Integer> {

	public Authority findByUserRole(String role);

}
