package com.cerveceroscodigo.spring.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class LoginController {

	@Autowired
	ItemController itemController;


	
	//Viser loginsiden
	@RequestMapping(value="/signin")
	public String displayLoginPage(){
		return "login";
	}
	
	
	//Viser loginsiden
	@RequestMapping(value="/logout")
	public String displayLoggedOut(SessionStatus status, HttpSession session){
		status.setComplete();
		itemController.deleteCart();
		itemController.resetLoggedOn();
		//session.setAttribute("cart", null);
		return "loggedout";
	}
	
	@RequestMapping(value="/denied")
	public String displayDenied(){
		return "denied";
	}
	

}
