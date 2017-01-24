package com.aredvi.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aredvi.dao.interfaces.InventoryDAO;
import com.aredvi.entity.Inventory;
import com.aredvi.exceptions.AredviException;
import com.aredvi.repository.InventoryRepo;

@Repository("inventoryDAO")
public class InventoryDAOImpl implements InventoryDAO{
	
	@Autowired
	InventoryRepo inventoryRepo;

	@Override
	public void addInventory(Inventory inventory) throws AredviException {
		inventoryRepo.save(inventory);
	}

	@Override
	public void updateInventory(Inventory inventory) throws AredviException {
		inventoryRepo.save(inventory);
	}

}
