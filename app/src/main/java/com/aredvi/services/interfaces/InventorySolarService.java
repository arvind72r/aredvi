package com.aredvi.services.interfaces;

import java.util.List;

import com.aredvi.exceptions.AredviException;
import com.aredvi.solr.Inventory;

public interface InventorySolarService {
	Inventory addInventoryProfile(Inventory inventory) throws AredviException;

	Inventory updateInventoryProfile(Inventory inventory) throws AredviException;

	Inventory getInventoryProfile(String solarId) throws AredviException;
	
	void deleteInventoryProfile(Inventory inventory) throws AredviException;

	List<Inventory> loadMapFrmSolr() throws AredviException;
}
