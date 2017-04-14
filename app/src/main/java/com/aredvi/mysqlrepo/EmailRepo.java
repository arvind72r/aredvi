package com.aredvi.mysqlrepo;

import org.springframework.data.repository.CrudRepository;

import com.aredvi.sqlentity.Email;

public interface EmailRepo extends CrudRepository<Email,Integer>{

}
