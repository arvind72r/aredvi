package com.aredvi.services.impl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.aredvi.dto.response.RespMapDTO;
import com.aredvi.entity.Place;
import com.aredvi.services.interfaces.SearchService;
import com.aredvi.utils.StringConstants;
import com.aredvi.utils.UtilityService;

@Service("searchService")
public class SearchServiceImpl implements SearchService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SearchServiceImpl.class);
	

	@Override
	public List<Place> autocomplete(String input) {
		List<Place> resultList = null;

		HttpURLConnection conn = null;
		StringBuilder jsonResults = new StringBuilder();
		try {
			StringBuilder sb = new StringBuilder(PLACES_API_BASE);
			sb.append(TYPE_AUTOCOMPLETE);
			sb.append(OUT_JSON);
			sb.append("?sensor=false");
			sb.append("&key=" + API_KEY);
			sb.append("&input=" + URLEncoder.encode(input, "utf8"));

			URL url = new URL(sb.toString());
			conn = (HttpURLConnection) url.openConnection();
			InputStreamReader in = new InputStreamReader(conn.getInputStream());

			int read;
			char[] buff = new char[1024];
			while ((read = in.read(buff)) != -1) {
				jsonResults.append(buff, 0, read);
			}
		} catch (MalformedURLException e) {
			LOGGER.error(LOG_TAG, "Error processing Places API URL", e);
			return resultList;
		} catch (IOException e) {
			LOGGER.error(LOG_TAG, "Error connecting to Places API", e);
			return resultList;
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}

		try {
			// Create a JSON object hierarchy from the results
			JSONObject jsonObj = new JSONObject(jsonResults.toString());
			JSONArray predsJsonArray = jsonObj.getJSONArray("predictions");

			// Extract the Place descriptions from the results
			resultList = new ArrayList<Place>(predsJsonArray.length());
			for (int i = 0; i < predsJsonArray.length(); i++) {
				Place place = new Place();
				place.setReference(predsJsonArray.getJSONObject(i).getString("reference"));
				place.setName(predsJsonArray.getJSONObject(i).getString("description"));
				resultList.add(place);
			}
		} catch (JSONException e) {
			LOGGER.error(LOG_TAG, "Error processing JSON results", e);
		}

		return resultList;
	}

	@Override
	public List<Place> search(String keyword, double lat, double lng, int radius) {
		List<Place> resultList = null;

		HttpURLConnection conn = null;
		StringBuilder jsonResults = new StringBuilder();
		try {
			StringBuilder sb = new StringBuilder(PLACES_API_BASE);
			sb.append(TYPE_SEARCH);
			sb.append(OUT_JSON);
			sb.append("?sensor=false");
			sb.append("&key=" + API_KEY);
			sb.append("&types=" + "doctor|hospital|pharmacy");
			// sb.append("&keyword=" + URLEncoder.encode(keyword, "utf8"));
			sb.append("&location=" + String.valueOf(lat) + "," + String.valueOf(lng));
			sb.append("&radius=" + String.valueOf(radius));

			URL url = new URL(sb.toString());
			conn = (HttpURLConnection) url.openConnection();
			InputStreamReader in = new InputStreamReader(conn.getInputStream());

			int read;
			char[] buff = new char[1024];
			while ((read = in.read(buff)) != -1) {
				jsonResults.append(buff, 0, read);
			}
		} catch (MalformedURLException e) {
			LOGGER.error(LOG_TAG, "Error processing Places API URL", e);
			return resultList;
		} catch (IOException e) {
			LOGGER.error(LOG_TAG, "Error connecting to Places API", e);
			return resultList;
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}

		try {
			// Create a JSON object hierarchy from the results
			JSONObject jsonObj = new JSONObject(jsonResults.toString());
			JSONArray predsJsonArray = jsonObj.getJSONArray("results");

			// Extract the Place descriptions from the results
			resultList = new ArrayList<Place>(predsJsonArray.length());
			for (int i = 0; i < predsJsonArray.length(); i++) {
				Place place = new Place();
				place.setReference(predsJsonArray.getJSONObject(i).getString("reference"));
				place.setName(predsJsonArray.getJSONObject(i).getString("name"));
				place.setType(predsJsonArray.getJSONObject(i).getJSONArray("types").getString(0));
				place.setLocationlat(predsJsonArray.getJSONObject(i).getJSONObject("geometry").getJSONObject("location")
						.getString("lat"));
				place.setLocationlng(predsJsonArray.getJSONObject(i).getJSONObject("geometry").getJSONObject("location")
						.getString("lng"));
				/*place.setNortheastlat(
						predsJsonArray.getJSONObject(i).getJSONObject("geometry").getJSONObject("location")
								.getJSONObject("viewport").getJSONObject("northeast").getString("lat"));
				place.setNortheastlng(
						predsJsonArray.getJSONObject(i).getJSONObject("geometry").getJSONObject("location")
								.getJSONObject("viewport").getJSONObject("northeast").getString("lng"));
				place.setSouthwestlat(
						predsJsonArray.getJSONObject(i).getJSONObject("geometry").getJSONObject("location")
								.getJSONObject("viewport").getJSONObject("southwest").getString("lat"));
				place.setSouthwestlng(
						predsJsonArray.getJSONObject(i).getJSONObject("geometry").getJSONObject("location")
								.getJSONObject("viewport").getJSONObject("southwest").getString("lng"));*/
				resultList.add(place);
			}
		} catch (JSONException e) {
			LOGGER.error(LOG_TAG, "Error processing JSON results", e);
		}

		return resultList;
	}

	@Override
	public Place details(String reference) {
		HttpURLConnection conn = null;
		StringBuilder jsonResults = new StringBuilder();
		try {

			StringBuilder sb = new StringBuilder(PLACES_API_BASE);
			sb.append(TYPE_DETAILS);
			sb.append(OUT_JSON);
			sb.append("?sensor=false");
			sb.append("&key=" + API_KEY);
			sb.append("&reference=" + URLEncoder.encode(reference, "utf8"));

			URL url = new URL(sb.toString());
			conn = (HttpURLConnection) url.openConnection();
			InputStreamReader in = new InputStreamReader(conn.getInputStream());

			// Load the results into a StringBuilder
			int read;
			char[] buff = new char[1024];
			while ((read = in.read(buff)) != -1) {
				jsonResults.append(buff, 0, read);
			}
		} catch (MalformedURLException e) {
			LOGGER.error(LOG_TAG, "Error processing Places API URL", e);
			return null;
		} catch (IOException e) {
			LOGGER.error(LOG_TAG, "Error connecting to Places API", e);
			return null;
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}

		Place place = null;
		try {
			// Create a JSON object hierarchy from the results
			JSONObject jsonObj = new JSONObject(jsonResults.toString()).getJSONObject("result");

			place = new Place();
			place.setIcon(jsonObj.getString("icon"));
			place.setName(jsonObj.getString("name"));
			place.setFormattedAddress(jsonObj.getString("formatted_address"));
			place.setLocationlat(jsonObj.getJSONObject("geometry").getJSONObject("location").getString("lat"));
			place.setLocationlat(jsonObj.getJSONObject("geometry").getJSONObject("location").getString("lng"));
			place.setNortheastlat(jsonObj.getJSONObject("geometry").getJSONObject("location").getJSONObject("viewport")
					.getJSONObject("northeast").getString("lat"));
			place.setNortheastlng(jsonObj.getJSONObject("geometry").getJSONObject("location").getJSONObject("viewport")
					.getJSONObject("northeast").getString("lng"));
			place.setSouthwestlat(jsonObj.getJSONObject("geometry").getJSONObject("location").getJSONObject("viewport")
					.getJSONObject("southwest").getString("lat"));
			place.setSouthwestlng(jsonObj.getJSONObject("geometry").getJSONObject("location").getJSONObject("viewport")
					.getJSONObject("southwest").getString("lng"));
			if (jsonObj.has("formatted_phone_number")) {
				place.setFormattedPhoneNumber(jsonObj.getString("formatted_phone_number"));
			}
		} catch (JSONException e) {
			LOGGER.error(LOG_TAG, "Error processing JSON results", e);
		}

		return place;
	}
	
	@Override
	public  List<RespMapDTO> search(double lat1, double lng1, double lat2, double lng2){
    	Map<String,Double> searchZone = UtilityService.getMidPoint(lat1,lng1,lat2,lng2);
    	int radius = searchZone.get(StringConstants.RADIUS).intValue();
    	if(radius == 0){
    		radius = 4;
    	}
    	List<Place> resultList = search("",searchZone.get(StringConstants.LAT),searchZone.get(StringConstants.LNG),radius);
    	List<RespMapDTO> formatedList = swapData(resultList);; 
    	return formatedList;
    }
	
	public List<RespMapDTO> swapData(List<Place> resultList ){
    	List<RespMapDTO> results= new ArrayList<RespMapDTO>();
    	int i = 0;
    	for(Place place : resultList){
    		i++;
    		RespMapDTO respMapDTO = new RespMapDTO();
    		respMapDTO.setGoogleRef(place.getReference());
    		respMapDTO.setLat(place.getLocationlat());
    		respMapDTO.setLng(place.getLocationlng());
    		respMapDTO.setName(place.getName());
    		respMapDTO.setType(place.getType());
    		if((i%5)==0){
    		respMapDTO.setRegistered(true);	
    		}else{
    			respMapDTO.setRegistered(false);
    		}
    		results.add(respMapDTO);
    	}
    	return results;
    }


}
