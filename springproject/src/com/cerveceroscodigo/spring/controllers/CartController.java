package com.cerveceroscodigo.spring.controllers;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cerveceroscodigo.spring.dao.Cart;
import com.cerveceroscodigo.spring.dao.Item;

@Controller
public class CartController {

//	@Autowired
	Cart cart;
	
	@RequestMapping(value="/showBasket")
	public String displayCartContents(Model model, HttpSession session){
		
		cart = (Cart) session.getAttribute("cart");
		
		List<Item> list = cart.getCartItems();
		
//		model.addAttribute("liste", list);
		model.addAttribute("cart", cart);
		
		return "showBasket";
		}	
}
