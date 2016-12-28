package com.aredvi.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.aredvi.entity.Inventory;
import com.aredvi.exceptions.AredviException;
import com.aredvi.repository.InventorySolarRepo;
import com.aredvi.services.interfaces.InventorySolarService;

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
		 inventorySolarRepo.delete(solarId);
		return null;
	}

	@Override
	public void deleteInventoryProfile(Inventory inventory) throws AredviException {
		  inventorySolarRepo.delete(inventory);
	}

}
