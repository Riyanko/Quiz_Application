package com.rio.quiz_app.controller.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class QuestionNotFoundException extends RuntimeException{
	public QuestionNotFoundException(String message){
		super(message);
	}
}
