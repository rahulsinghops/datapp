package com.ipru.mca.BikeOpedia.exceptionHandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.ipru.mca.BikeOpedia.model.BikeException;

@ControllerAdvice
public class ExceptionHandler {
	@org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> fetValidationException(MethodArgumentNotValidException e)
	{
		BikeException ex= new BikeException(new Date(), e.getBindingResult().getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST.toString());
		return new ResponseEntity<>(ex,  HttpStatus.BAD_REQUEST);
		
	}

}
