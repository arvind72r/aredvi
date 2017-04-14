package com.aredvi.mysqlrepo;

import org.springframework.data.repository.CrudRepository;

import com.aredvi.sqlentity.Address;

public interface AddressRepo extends CrudRepository<Address,Integer>{

}
