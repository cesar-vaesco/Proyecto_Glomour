package com.glamour.restapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class ExceptionHandlerExceptionResolver extends Exception{

	private static final long serialVersionUID = 1L;
	
	public ExceptionHandlerExceptionResolver(String message) {
		super(message);
	}
	
}
