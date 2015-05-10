package com.cerveceroscodigo.spring.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.cerveceroscodigo.spring.dao.Cart;

@Controller
public class CartController {

	// @Autowired
	Cart cart;

	@RequestMapping(value = "/showBasket")
	public String displayCartContents(Model model, HttpSession session) {

		cart = (Cart) session.getAttribute("cart");

		model.addAttribute("cart", cart);

		return "showBasket";
	}

	@RequestMapping(value = "/allDone")
	public String displayAllDone(SessionStatus status, HttpSession session) {
		
		session.invalidate();
		status.setComplete();
		
		return "allDone";
	}

}
