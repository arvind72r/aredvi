package com.aredvi.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aredvi.entity.Place;
import com.aredvi.services.interfaces.SearchService;
import com.aredvi.utils.ResponseFormatter;

@RestController
@RequestMapping(value = "/search")
public class SearchController {
	
	@Resource(name = "searchService")
	private SearchService searchService;
	
	@RequestMapping(value = "/nearby", method = RequestMethod.GET)
	public ResponseFormatter<ArrayList<Place>> nearBy(@RequestParam String lat,@RequestParam String lng,
			@RequestParam String radius){
		ResponseFormatter<ArrayList<Place>> resp = new ResponseFormatter<ArrayList<Place>>();
		double vlat = (lat == null || lat.equals("")) ? 0.0 : Double.parseDouble(lat);
		double vlng = (lng == null || lng.equals("")) ? 0.0 : Double.parseDouble(lng);
		int vRadius = (radius == null || radius.equals("")) ? 0 : Integer.parseInt(radius);
		ArrayList<Place> places = searchService.search("doctor|hospital", vlat, vlng, vRadius);
		resp.setResponseData(places);
		return resp;
	}
	
	@RequestMapping(value = "/nearbysearch", method = RequestMethod.GET)
	public ResponseFormatter<ArrayList<Place>> nearBySearch(@RequestParam String type,@RequestParam String lat,
			@RequestParam String lng, @RequestParam String radius){
		ResponseFormatter<ArrayList<Place>> resp = new ResponseFormatter<ArrayList<Place>>();
		double vlat = (lat == null || lat.equals("")) ? 0.0 : Double.parseDouble(lat);
		double vlng = (lng == null || lng.equals("")) ? 0.0 : Double.parseDouble(lng);
		int vRadius = (radius == null || radius.equals("")) ? 0 : Integer.parseInt(radius);
		ArrayList<Place> places = searchService.search(type, vlat, vlng, vRadius);
		resp.setResponseData(places);
		return resp;
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ResponseFormatter<Place> detail(@RequestParam String reference){
		ResponseFormatter<Place> resp = new ResponseFormatter<Place>();
		Place place = searchService.details(reference);
		resp.setResponseData(place);
		return resp;
	}
}
