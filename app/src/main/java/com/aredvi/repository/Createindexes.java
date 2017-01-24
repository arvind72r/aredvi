package com.aredvi.repository;

public class Createindexes {
	public static final String INVENTORY_FULL_NAME="CREATE INDEX INVENTORY_FULL_NAME ON inventory(fullname);";
	public static final String INVENTORY_GOOGLE_ID="CREATE INDEX INVENTORY_GOOGLE_ID ON inventory(google_id);";
	public static final String INVENTORY_PLACE_ID="CREATE INDEX INVENTORY_PLACE_ID ON inventory(place_id);";
}
