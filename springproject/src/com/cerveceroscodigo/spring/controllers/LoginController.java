package com.cerveceroscodigo.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {


	//Viser loginsiden
	@RequestMapping(value="/signin")
	public String displayLoginPage(){
		return "login";
	}
	
	
	//Viser loginsiden
	@RequestMapping(value="/logout")
	public String displayLoggedOut(){
		return "loggedout";
	}
	
	@RequestMapping(value="/denied")
	public String displayDenied(){
		return "denied";
	}
}
