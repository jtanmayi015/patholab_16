package com.patholab.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.patholab.dto.Response;

@ControllerAdvice
public class RestControllerExceptionHandler {
	@ExceptionHandler({RuntimeException.class})
	public ResponseEntity<?> handleRuntimeException(RuntimeException ex) {
		return Response.error(ex.getMessage());
	}
}
