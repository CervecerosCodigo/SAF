package com.cerveceroscodigo.spring.controllers;

import java.nio.file.AccessDeniedException;

import org.hibernate.LazyInitializationException;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
	
//	@ExceptionHandler(LazyInitializationException.class)
//	public String handleLazyInitException(LazyInitializationException ex){
//		return "error";
//	}
	
	
	@ExceptionHandler(DataAccessException.class)
	public String handleDatabaseException(DataAccessException ex) {
		ex.printStackTrace();
		return "error";
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public String handleAccessException(AccessDeniedException ex) {
		return "denied";
	}
	
	
}
