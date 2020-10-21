package com.github.vtspp.services.exceptions;

public class ObjectAlreadyRegisteredException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ObjectAlreadyRegisteredException(String msg) {
		super(msg);
	}

}
