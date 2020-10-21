package com.github.vtspp.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.github.vtspp.services.exceptions.ObjectAlreadyRegisteredException;
import com.github.vtspp.services.exceptions.ObjectNotFoundException;

public interface ResourceExceptionHandler {
	
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request);
	
	public ResponseEntity<StandardError> objectAlreadyRegistered(ObjectAlreadyRegisteredException e, HttpServletRequest request);

}
