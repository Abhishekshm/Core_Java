package com.bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;



@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundHandling(ResourceNotFoundException exception,WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(exception.getMessage(),request.getDescription(false));
		
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(BankNotFoundException.class)
	public ResponseEntity<?> bankNotFoundHandling(BankNotFoundException exception,WebRequest request){
		ErrorDetails error = new ErrorDetails(exception.getMessage(),request.getDescription(false));
		return new  ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
}
