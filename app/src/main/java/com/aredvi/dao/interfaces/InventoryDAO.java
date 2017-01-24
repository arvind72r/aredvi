package com.aredvi.dao.interfaces;

import com.aredvi.entity.Inventory;
import com.aredvi.exceptions.AredviException;

public interface InventoryDAO {

	void addInventory(Inventory inventory) throws AredviException;

	void updateInventory(Inventory inventory) throws AredviException;

}
