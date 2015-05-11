package com.cerveceroscodigo.spring.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class CartController {

	@Autowired
	ItemController itemController;

	@RequestMapping(value = "/showBasket")
	public String displayCartContents(Model model) {

		return "showBasket";
	}

	@RequestMapping(value = "/allDone")
	public String displayAllDone(SessionStatus status, HttpSession session) {
		
		session.invalidate();
		status.setComplete();
		itemController.deleteCart();
		itemController.resetLoggedOn();
		//session.setAttribute("cart", null);
		return "allDone";
	}

}
