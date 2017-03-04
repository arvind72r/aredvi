package com.aredvi.solr;


import java.util.List;

import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;


public interface InventorySolarRepo extends SolrCrudRepository<Inventory,Long>{
	@Query("fname:?0")
	public List<Inventory> findByFullName(String fullname);

}
