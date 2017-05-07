package com.aredvi.utils;

import java.util.ArrayList;
import java.util.List;

import com.aredvi.exceptions.AredviExceptionDetail;

public class ResponseFormatter<T>{
	private String sessionId;

	private T responseData;

	private List<AredviExceptionDetail> errorMessages = new ArrayList<AredviExceptionDetail>();

	private boolean hasException;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public T getResponseData() {
		return responseData;
	}

	public void setResponseData(T responseData) {
		this.responseData = responseData;
	}

	public List<AredviExceptionDetail> getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(List<AredviExceptionDetail> errorMessages) {
		this.errorMessages = errorMessages;
	}

	public boolean isHasException() {
		return hasException;
	}

	public void setHasException(boolean hasException) {
		this.hasException = hasException;
	}

	public ResponseFormatter(String sessionId, T responseData, List<AredviExceptionDetail> errorMessages,
			boolean hasException) {
		this.sessionId = sessionId;
		this.responseData = responseData;
		this.errorMessages = errorMessages;
		this.hasException = hasException;
	}

	public ResponseFormatter() {

	}
}
