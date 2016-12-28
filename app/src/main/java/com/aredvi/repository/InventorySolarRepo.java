package com.aredvi.repository;

import org.springframework.data.solr.repository.SolrCrudRepository;

import com.aredvi.entity.Inventory;

public interface InventorySolarRepo extends SolrCrudRepository<Inventory, String>{

}
