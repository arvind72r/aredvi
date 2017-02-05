package com.aredvi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aredvi.dto.response.RespMapDTO;
import com.aredvi.entity.Place;
import com.aredvi.services.interfaces.SearchService;
import com.aredvi.utils.ResponseFormatter;

@RestController
@RequestMapping(value = "/search")
public class SearchController {
	
	@Resource(name = "searchService")
	private SearchService searchService;
	
	@RequestMapping(value = "/nearby", method = RequestMethod.GET)
	public ResponseFormatter<List<Place>> nearBy(@RequestParam String lat,@RequestParam String lng,
			@RequestParam String radius){
		ResponseFormatter<List<Place>> resp = new ResponseFormatter<List<Place>>();
		double vlat = (lat == null || lat.equals("")) ? 0.0 : Double.parseDouble(lat);
		double vlng = (lng == null || lng.equals("")) ? 0.0 : Double.parseDouble(lng);
		int vRadius = (radius == null || radius.equals("")) ? 0 : Integer.parseInt(radius);
		List<Place> places = searchService.search("doctor|hospital", vlat, vlng, vRadius);
		resp.setResponseData(places);
		return resp;
	}
	
	@RequestMapping(value = "/nearbysearch", method = RequestMethod.GET)
	public ResponseFormatter<List<Place>> nearBySearch(@RequestParam String type,@RequestParam String lat,
			@RequestParam String lng, @RequestParam String radius){
		ResponseFormatter<List<Place>> resp = new ResponseFormatter<List<Place>>();
		double vlat = (lat == null || lat.equals("")) ? 0.0 : Double.parseDouble(lat);
		double vlng = (lng == null || lng.equals("")) ? 0.0 : Double.parseDouble(lng);
		int vRadius = (radius == null || radius.equals("")) ? 0 : Integer.parseInt(radius);
		List<Place> places = searchService.search(type, vlat, vlng, vRadius);
		resp.setResponseData(places);
		return resp;
	}
	
	@RequestMapping(value = "/loadmap", method = RequestMethod.GET)
	public ResponseFormatter<List<RespMapDTO>> loadMap(@RequestParam String lat1,
			@RequestParam String lng1, @RequestParam String lat2, @RequestParam String lng2){
		ResponseFormatter<List<RespMapDTO>> resp = new ResponseFormatter<List<RespMapDTO>>();
		double vlat1 = (lat1 == null || lat1.equals("")) ? 0.0 : Double.parseDouble(lat1);
		double vlng1 = (lng1 == null || lng1.equals("")) ? 0.0 : Double.parseDouble(lng1);
		double vlat2 = (lat2 == null || lat2.equals("")) ? 0.0 : Double.parseDouble(lat2);
		double vlng2 = (lng2 == null || lng2.equals("")) ? 0.0 : Double.parseDouble(lng2);
		List<RespMapDTO> places = searchService.search(vlat1, vlng1, vlat2, vlng2);
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
