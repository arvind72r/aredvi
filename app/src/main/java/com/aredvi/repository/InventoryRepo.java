package com.aredvi.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.aredvi.entity.Inventory;

public interface InventoryRepo extends CassandraRepository<Inventory>{

}
