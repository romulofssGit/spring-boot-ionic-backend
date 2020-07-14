package com.romulocurso.cursomc.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.romulocurso.cursomc.services.exceptions.DataIntegrityException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objNotFound(ObjectNotFoundException e, HttpServletRequest request) {		
		StandardError err = new StandardError( HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis() );
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException e, HttpServletRequest request) {		
		StandardError err = new StandardError( HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis() );
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}	
}
