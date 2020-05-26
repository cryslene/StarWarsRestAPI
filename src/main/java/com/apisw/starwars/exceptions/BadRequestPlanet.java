package com.apisw.starwars.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BadRequestPlanet extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public BadRequestPlanet(String msg) {
		super(msg);
	}
}
