package com.aredvi.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aredvi.exceptions.AredviException;
import com.aredvi.services.interfaces.InventorySolarService;
import com.aredvi.solr.Inventory;
import com.aredvi.solr.InventorySolarRepo;

@Service("inventorySolarService")
public class InventorySolarServiceImpl implements InventorySolarService {
	
	@Autowired
	InventorySolarRepo inventorySolarRepo;

	@Override
	public Inventory addInventoryProfile(Inventory inventory) throws AredviException {
		return inventorySolarRepo.save(inventory);
	}

	@Override
	public Inventory updateInventoryProfile(Inventory inventory) throws AredviException {
		return inventorySolarRepo.save(inventory);
	}

	@Override
	public Inventory getInventoryProfile(String solarId) throws AredviException {
		 //inventorySolarRepo.
		return null;
	}

	@Override
	public void deleteInventoryProfile(Inventory inventory) throws AredviException {
		  inventorySolarRepo.delete(inventory);
	}

	@Override
	public List<Inventory> loadMapFrmSolr() throws AredviException {
		return  (List<Inventory>) inventorySolarRepo.findAll();
		//return inventorySolarRepo.findByFullName("sushant");
	}

}
