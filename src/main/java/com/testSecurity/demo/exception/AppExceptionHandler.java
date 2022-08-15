package com.testSecurity.demo.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.testSecurity.demo.dto.ErrorResponse;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler{	
	@ExceptionHandler(value = {UserException.class})
	public ResponseEntity<Object> handleException(UserException e, WebRequest request){
		String message = e.getLocalizedMessage();
		return new ResponseEntity<>(new ErrorResponse(message), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
