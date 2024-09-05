package com.rio.quiz_app.controller.exceptionhandling;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomisedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllException(Exception ex, WebRequest request) throws Exception{
		ErrorDetails errorDetails=new ErrorDetails(
			LocalDateTime.now(),ex.getMessage(),request.getDescription(false)
		);
		return ResponseEntity.internalServerError().body(errorDetails);
	}
	
	@ExceptionHandler(CategoryNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleCategoryNotFoundException(Exception ex, WebRequest request) throws Exception{
		ErrorDetails errorDetails=new ErrorDetails(	
				LocalDateTime.now(),
				ex.getMessage(),
				request.getDescription(false)
		);
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
	}
}
