package com.aredvi.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.aredvi.entity.UserRole;

public interface UserRoleRepo extends CrudRepository<UserRole, String>{

	public Set<UserRole> findByUserId(String string);

}
