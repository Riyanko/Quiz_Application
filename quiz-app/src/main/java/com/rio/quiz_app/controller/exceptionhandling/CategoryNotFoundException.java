package com.rio.quiz_app.controller.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class CategoryNotFoundException extends RuntimeException {
	public CategoryNotFoundException(String str){
		super(str);
	}
}
