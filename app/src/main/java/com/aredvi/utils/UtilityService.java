package com.aredvi.utils;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
public class UtilityService {
	public static void writeLog(final Logger logger, Exception ex) {
		StringBuilder strBuffer = new StringBuilder(ex.getMessage());
		StackTraceElement[] stactTraceElements = ex.getStackTrace();
		for (StackTraceElement ste : stactTraceElements) {
			strBuffer.append(ste.toString());
		}
		logger.error(strBuffer.toString());
	}
	
	/**
	 * Description find mid point coordinates
	 * @param lat1
	 * @param lon1
	 * @param lat2
	 * @param lon2
	 * @return
	 */
	public static Map<String,Double> getMidPoint(double lat1,double lon1,
			double lat2,double lon2){
		Map<String,Double> searchZone = new HashMap<String,Double>();
		double dLon = Math.toRadians(lon2 - lon1);
		double vLat = lat1;
		double vLon = lon1;
	    //convert to radians
	    lat1 = Math.toRadians(lat1);
	    lat2 = Math.toRadians(lat2);
	    lon1 = Math.toRadians(lon1);

	    double Bx = Math.cos(lat2) * Math.cos(dLon);
	    double By = Math.cos(lat2) * Math.sin(dLon);
	    double lat3 = Math.atan2(Math.sin(lat1) + Math.sin(lat2), Math.sqrt((Math.cos(lat1) + Bx) * (Math.cos(lat1) + Bx) + By * By));
	    double lon3 = lon1 + Math.atan2(By, Math.cos(lat1) + Bx);

	    
	    double vLat3 =  Math.toDegrees(lat3);
	    double vLon3 = Math.toDegrees(lon3);
	    
	    //Find distance between points 
	    double radius = getRadius(vLat,vLon,vLat3,vLon3);
	    
	    //print out in degrees
	    searchZone.put(StringConstants.LAT, vLat3);
	    searchZone.put(StringConstants.LNG, vLon3);
	    searchZone.put(StringConstants.RADIUS, new Double(radius));
		return searchZone;
	}
	
	/**
	 * Description find distance between  coordinates
	 * @param lat1
	 * @param lon1
	 * @param lat2
	 * @param lon2
	 * @return
	 */
	public static double getRadius(double lat1,double lon1,
			double lat2,double lon2){
		double dLat = Math.toRadians(lat1 - lat2);
		double dLon = Math.toRadians(lon1 - lon2);

		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
		           + Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(lat1))
		           * Math.sin(dLon / 2) * Math.sin(dLon / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double d = 6371 * c;
		d = d * 1000;
		return d;
	}
}
