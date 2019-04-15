package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExeptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponce> handlerException(CustomerNotFoundException exp){
		CustomerErrorResponce error = new CustomerErrorResponce(HttpStatus.NOT_FOUND.value(), exp.getMessage(), System.currentTimeMillis());
		
		return new ResponseEntity<>(error , HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponce> handlerException(Exception exp){
		CustomerErrorResponce error = new CustomerErrorResponce(HttpStatus.BAD_REQUEST.value(), exp.getMessage(), System.currentTimeMillis());
		
		return new ResponseEntity<>(error , HttpStatus.NOT_FOUND);
	}
	

}
