package com.github.vtspp.resources.exception;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.github.vtspp.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		StandardError err = new StandardError(System.currentTimeMillis(), 
				                              HttpStatus.NOT_FOUND.value(), 
				                              "Não encontrado", 
				                              e.getMessage(), 
				                              request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(err);
	}

}
