package com.aredvi.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.aredvi.exceptions.AredviException;
import com.aredvi.exceptions.AredviExceptionDetail;
import com.aredvi.exceptions.AredviServiceException;
import com.aredvi.exceptions.InvalidRequestException;
import com.aredvi.exceptions.UserNameExistException;
import com.aredvi.exceptions.UserNotFoundException;
import com.aredvi.utils.ResponseFormatter;

public class AredviController {


	private static final String ERROR_STACK_TRACE = "Error Stack Trace:: ";

	@Autowired
	private MessageSource vMessageSource;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AredviController.class);

	@ExceptionHandler(SQLException.class)
	public String handleSQLException(HttpServletRequest pRequest){
		LOGGER.info("SQLException Occured:: URL="+pRequest.getRequestURL());
		return "database_error";

	}


	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="IOException occured")
	@ExceptionHandler(IOException.class)
	public void handleIOException(Exception pEx){
		LOGGER.error("IO Exception occured:: ",pEx);		
	}

	@ExceptionHandler(AredviException.class)
	public ResponseFormatter<Object> handleOrbitApiException(Exception pEx){
		LOGGER.info("*** handleOrbitApiException method called ***");
		
		AredviExceptionDetail vError=null;
		ResponseFormatter<Object> vErrorResponse=new ResponseFormatter<Object>();
		List<AredviExceptionDetail> vErrList=new ArrayList<AredviExceptionDetail>();
		if(pEx instanceof InvalidRequestException){
			vError=new AredviExceptionDetail((InvalidRequestException) pEx);
		} 
		else if(pEx instanceof UserNameExistException){
			vError=new AredviExceptionDetail((UserNameExistException) pEx);
		}
		else if (pEx instanceof UserNotFoundException){
			vError=new AredviExceptionDetail((UserNotFoundException) pEx);
		} else {
			vError=new AredviExceptionDetail((AredviServiceException) pEx);
		}
		
		vErrList.add(vError);
		vErrorResponse.setErrorMessages(vErrList);
		return vErrorResponse;
	} 

	

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseFormatter<Object> processValidationError(MethodArgumentNotValidException pEx) {
		BindingResult vResult = pEx.getBindingResult();
		List<FieldError> vFieldErrors = vResult.getFieldErrors();

		return processFieldErrors(vFieldErrors);
	}

	private ResponseFormatter<Object> processFieldErrors(List<FieldError> pFieldErrors) {
		ResponseFormatter<Object> vErrorResponse = new ResponseFormatter<Object>();
		List<AredviExceptionDetail> exceptions = new ArrayList<AredviExceptionDetail>();
		for (FieldError vFieldError: pFieldErrors) {
			String vLocalizedErrorMessage = resolveLocalizedErrorMessage(vFieldError);
			AredviExceptionDetail aredviExceptionDetail = 
					new AredviExceptionDetail(vFieldError.getField(),vLocalizedErrorMessage);
			exceptions.add(aredviExceptionDetail);
		}
		vErrorResponse.setErrorMessages(exceptions);
		return vErrorResponse;
	}

	private String resolveLocalizedErrorMessage(FieldError pFieldError) {
		Locale vCurrentLocale =  LocaleContextHolder.getLocale();

		return vMessageSource.getMessage(pFieldError, vCurrentLocale);
	}
	

}
