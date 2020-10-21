package com.github.vtspp.resources.exception.impl;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.github.vtspp.resources.exception.ResourceExceptionHandler;
import com.github.vtspp.resources.exception.StandardError;
import com.github.vtspp.services.exceptions.ObjectAlreadyRegisteredException;
import com.github.vtspp.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandlerImpl implements Serializable, ResourceExceptionHandler{
	private static final long serialVersionUID = 1L;
	
	@Override
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		StandardError err = new StandardError(System.currentTimeMillis(), 
				                              HttpStatus.NOT_FOUND.value(), 
				                              "Não encontrado", 
				                              e.getMessage(), 
				                              request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(err);
	}
	
	@Override
	@ExceptionHandler(ObjectAlreadyRegisteredException.class)
	public ResponseEntity<StandardError> objectAlreadyRegistered(ObjectAlreadyRegisteredException e, HttpServletRequest request){
		StandardError err = new StandardError(System.currentTimeMillis(), 
				                              HttpStatus.CONFLICT.value(), 
				                              "Conflito ao cadastrar", 
				                              e.getMessage(), 
				                              request.getRequestURI());
		return ResponseEntity.status(HttpStatus.CONFLICT.value()).body(err);
	}


}
