package com.phone.contacts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler{
@ExceptionHandler(ContactNotFoundException.class)
	public ResponseEntity<ErrorResponse> contactNotFound(ContactNotFoundException exception) {
	return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse(500,exception.getMessage()));
}
@ExceptionHandler(ContactIsAlreadyExists.class)
public ResponseEntity<ErrorResponse> contactIsAlreadyExists(ContactIsAlreadyExists exception) {
return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse(500,exception.getMessage()));
}
}
