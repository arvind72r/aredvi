package com.aredvi.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.aredvi.entity.Inventory;
import com.aredvi.exceptions.AredviException;
import com.aredvi.repository.InventoryRepo;
import com.aredvi.services.interfaces.InventoryService;

public class InventoryServiceImpl implements InventoryService {
	
	@Autowired
	InventoryRepo inventoryRepo;

	@Override
	public Inventory addInventoryProfile(Inventory inventory) throws AredviException {
		return inventoryRepo.save(inventory);
	}

	@Override
	public Inventory updateInventoryProfile(Inventory inventory) throws AredviException {
		return inventoryRepo.save(inventory);
	}

	@Override
	public Inventory getInventoryProfile(String solarId) throws AredviException {
		return null;
	}

	@Override
	public Inventory deleteInventoryProfile(Inventory inventory) throws AredviException {
		return null;
	}

}
