package com.aredvi.utils;
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
}
