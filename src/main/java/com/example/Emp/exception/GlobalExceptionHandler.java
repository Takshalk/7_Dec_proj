package com.example.Emp.exception;

import org.springframework.http.HttpStatus;import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(EmpNotFoundException.class)
	public ResponseEntity<String> handleEmpNotFoundException(EmpNotFoundException e)
	{
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(EmpUpdateDone.class)
	public ResponseEntity<String> EmpUpdateDoneMsg(EmpUpdateDone e)
	{
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.OK);
	}

}
