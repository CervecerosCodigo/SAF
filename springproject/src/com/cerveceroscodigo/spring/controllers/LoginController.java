package com.cerveceroscodigo.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	//Autentiserer
	@RequestMapping(value="/signin", method=RequestMethod.POST)
	public String evaluteLoginAttempt(){
		System.out.println("Trying to log in. POST");
		return "registered";
	}

	//Viser loginsiden
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String displayLoginPage(){
		System.out.println("Trying to log in. GET");
		return "login";
	}
}
