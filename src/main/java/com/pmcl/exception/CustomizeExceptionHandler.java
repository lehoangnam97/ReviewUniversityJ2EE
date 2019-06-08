package com.pmcl.exception;

import org.springframework.http.HttpHeaders; 
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler; 
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizeExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ IdNotFoundException.class })
	protected ResponseEntity<Object> handleIdNotFound(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "Not found id";
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler({ IdNotValidException.class })
	protected ResponseEntity<Object> handleIdNotValid(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "Not valid id. Check if it is a hexa digital code";
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
}
