package com.aredvi.mysqlrepo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aredvi.sqlentity.User;


public interface UserRepo extends CrudRepository<User,Integer> {
	public List<User> findByType(String type);

	public List<User> findByFname(String name);

	public User findByUserId(int usrId);
}
