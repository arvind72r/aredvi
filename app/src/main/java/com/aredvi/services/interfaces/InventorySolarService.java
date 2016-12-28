package com.aredvi.services.interfaces;

import com.aredvi.entity.Inventory;
import com.aredvi.exceptions.AredviException;

public interface InventorySolarService {
	Inventory addInventoryProfile(Inventory inventory) throws AredviException;

	Inventory updateInventoryProfile(Inventory inventory) throws AredviException;

	Inventory getInventoryProfile(String solarId) throws AredviException;
	
	void deleteInventoryProfile(Inventory inventory) throws AredviException;
}
