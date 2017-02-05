package com.aredvi.services.interfaces;

import java.util.List;

import com.aredvi.dto.response.RespMapDTO;
import com.aredvi.entity.Place;

public interface SearchService {
	public static final String LOG_TAG = "SearchImpl";
	public static final String PLACES_API_BASE = "https://maps.googleapis.com/maps/api/place";
	public static final String TYPE_AUTOCOMPLETE = "/autocomplete";
	public static final String TYPE_DETAILS = "/details";
	public static final String TYPE_SEARCH = "/search";
	public static final String OUT_JSON = "/json";
	public static final String API_KEY = "AIzaSyCeAgA7UGqjrRxqKUw410H5XMwEXGXEAlA";

	public List<Place> autocomplete(String input);

	public Place details(String reference);

	public List<Place> search(String keyword, double lat, double lng, int radius);
	
	public  List<RespMapDTO> search(double lat1, double lng1, double lat2, double lng2);
}
