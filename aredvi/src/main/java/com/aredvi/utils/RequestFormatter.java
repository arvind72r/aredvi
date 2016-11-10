package com.aredvi.utils;

import java.util.Map;

public class RequestFormatter<T> {
	private Map<String, String> requestMode;

	private String sessionID;

	private T requestData;

	public RequestFormatter(Map<String, String> requestMode, String sessionId, T requestData) {
		super();
		this.requestMode = requestMode;
		this.sessionID = sessionId;
		this.requestData = requestData;
	}

	public RequestFormatter() {
	}

	public Map<String, String> getRequestMode() {
		return requestMode;
	}

	public void setRequestMode(Map<String, String> requestMode) {
		this.requestMode = requestMode;
	}

	public String getSessionID() {
		return sessionID;
	}

	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}

	public T getRequestData() {
		return requestData;
	}

	public void setRequestData(T requestData) {
		this.requestData = requestData;
	}
}
