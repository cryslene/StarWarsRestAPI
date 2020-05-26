package com.apisw.starwars.exceptions;

public class ServiceError extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ServiceError(String msg) {
		super(msg);
	}
}
