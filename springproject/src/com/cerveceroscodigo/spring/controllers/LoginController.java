package com.cerveceroscodigo.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {


	//Viser loginsiden
	@RequestMapping(value="/signin")
	public String displayLoginPage(){
		return "login";
	}
}
