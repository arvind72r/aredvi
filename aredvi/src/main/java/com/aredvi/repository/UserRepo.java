package com.aredvi.repository;

import org.springframework.data.repository.CrudRepository;

import com.aredvi.entity.User;

public interface UserRepo extends CrudRepository<User, String> {

}
