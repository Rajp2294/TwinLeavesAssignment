package com.twinleaves.assignment.exception;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.twinleaves.assignment.controller.common.BaseController;
import com.twinleaves.assignment.dto.response.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler extends BaseController<Object> {
	
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse<Object>> handleValidationErrors (MethodArgumentNotValidException exception,WebRequest webRequest) {
		logger.error("Exception occured: {}", exception.getMessage());
		String error = exception.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList()).get(0);
		return error(error, HttpStatus.BAD_REQUEST, webRequest.getDescription(false));
	}
	
	@ExceptionHandler(NoSuchMethodException.class)
	public ResponseEntity<ErrorResponse<Object>> noSuchMethodException (RuntimeException exception,WebRequest webRequest) {
		logger.error("Exception occured: {}", exception.getMessage());
		return error(exception.getMessage(), HttpStatus.BAD_REQUEST, webRequest.getDescription(false));
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorResponse<Object>> illegalArgumentException (RuntimeException exception,WebRequest webRequest) {
		logger.error("Exception occured: {}", exception.getMessage());
		return error(exception.getMessage(), HttpStatus.BAD_REQUEST, webRequest.getDescription(false));
	}
	
	@ExceptionHandler(InvocationTargetException.class)
	public ResponseEntity<ErrorResponse<Object>> invocationTargetException (RuntimeException exception,WebRequest webRequest) {
		logger.error("Exception occured: {}", exception.getMessage());
		return error(exception.getMessage(), HttpStatus.BAD_REQUEST, webRequest.getDescription(false));
	}
	
	@ExceptionHandler(IOException.class)
	public ResponseEntity<ErrorResponse<Object>> handleIOException (IOException exception,WebRequest webRequest) {
		logger.error("Exception occured: {}", exception.getMessage());
		return error(exception.getMessage(), HttpStatus.BAD_REQUEST, webRequest.getDescription(false));
	}
	
	@ExceptionHandler(DataFormatException.class)
	public ResponseEntity<ErrorResponse<Object>> handleDataFormatException (DataFormatException exception,WebRequest webRequest) {
		logger.error("Exception occured: {}", exception.getMessage());
		return error(exception.getMessage(), HttpStatus.BAD_REQUEST, webRequest.getDescription(false));
	}

}
