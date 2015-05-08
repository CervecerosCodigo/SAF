package com.cerveceroscodigo.spring.controllers;

public class CustomErrorException extends Exception{

	public CustomErrorException(String message){
		super(message);
	}
}
