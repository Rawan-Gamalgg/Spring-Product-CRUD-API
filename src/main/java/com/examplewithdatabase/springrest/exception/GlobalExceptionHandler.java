package com.examplewithdatabase.springrest.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//Any error in any controller will be handled here 
@RestControllerAdvice
public class GlobalExceptionHandler {
	//product not found  
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNotFound(NoSuchElementException ex) {
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
	}
	//validation for the data to be added
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach(error -> {
	        String fieldName = ((FieldError) error).getField();
	        String message = error.getDefaultMessage();
	        errors.put(fieldName, message);
	    });
	    return ResponseEntity.badRequest().body(errors);
	}

}
