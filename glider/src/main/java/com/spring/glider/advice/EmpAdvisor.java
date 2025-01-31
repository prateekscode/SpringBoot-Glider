package com.spring.glider.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestClientException;

@ControllerAdvice
public class EmpAdvisor {
	@ExceptionHandler(Exception.class)
	ResponseEntity<String> getException(Exception ex) {
		System.out.println("if exception occured call this method");
		return new ResponseEntity<> ("No Such Element Present",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(RestClientException.class)
	ResponseEntity<String> getException(RestClientException ex) {
		System.out.println("if exception occured call this method");
		return new ResponseEntity<> ("No Such Element Present.Please check your request",HttpStatus.BAD_REQUEST);
	}
}
