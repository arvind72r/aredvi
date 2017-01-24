package com.aredvi.services.interfaces;

import java.util.ArrayList;

import com.aredvi.entity.Place;

public interface SearchService {
	public static final String LOG_TAG = "SearchImpl";
	public static final String PLACES_API_BASE = "https://maps.googleapis.com/maps/api/place";
	public static final String TYPE_AUTOCOMPLETE = "/autocomplete";
	public static final String TYPE_DETAILS = "/details";
	public static final String TYPE_SEARCH = "/search";
	public static final String OUT_JSON = "/json";
	public static final String API_KEY = "AIzaSyCeAgA7UGqjrRxqKUw410H5XMwEXGXEAlA";

	public ArrayList<Place> autocomplete(String input);

	public Place details(String reference);

	public ArrayList<Place> search(String keyword, double lat, double lng, int radius);
}
