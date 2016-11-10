package com.aredvi.repository;

import org.springframework.data.repository.CrudRepository;

import com.aredvi.entity.Authority;

public interface AuthorityRepo extends CrudRepository<Authority, String>{

	Authority finByRole(String role);

}
