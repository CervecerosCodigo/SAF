package com.cerveceroscodigo.spring.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cerveceroscodigo.spring.dao.Cart;
import com.cerveceroscodigo.spring.dao.Item;
import com.cerveceroscodigo.spring.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService items;
	private Cart cart;
	private String loggedOn;

	@RequestMapping(value="/newitem", method = RequestMethod.GET)
	public String displayItemRegistration(Model model) {
			model.addAttribute("item", new Item());
		return "registeritem";
	}

	
	@RequestMapping(value="/newitem", method = RequestMethod.POST)
	public String createItem(Model model, Item item, BindingResult result) {
		if (!result.hasErrors()) {
			items.create(item); //@TODO: Denne må endres til at den returnerer boolean
			return "registereditem"; // ref to page if registered
		}
		return "registeritem"; // ref to the regsitering page
	}

	
	@RequestMapping(value="/showItems")
	public String showAllItems(Model model, HttpSession session, Principal principal) {
		session.setMaxInactiveInterval(60*15); //setter session valid til 15 min
		
		if(loggedOn == null){
			System.out.println("Legger til en ny vogn");
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		if(principal != null)
			loggedOn = principal.getName();
		List<Item> list = items.showAllItems();
		if(list != null)
			model.addAttribute("liste", list);
		
		return "showItems";
	}
	
	/*
	 * Det var en bugg relatert til da brukeren går inn på produksiden på nytt som gjorde at det blir lagt inn 
	 * en ny tom vare inn i kundevognen ettersom det blir kjørt add med en to GET variabel. 
	 * Skal forsøke å løse dette med egen dedikert metode som skal kun brukes dersom det mottas GET. 
	 */
	@RequestMapping(value="addItemToCart", method = RequestMethod.GET)
	public String addItemToCart(@ModelAttribute Item item){
		
		
		cart.addToCart(item);
		
		System.out.println("Content of the cart:");
		System.out.println(cart.toString());
		
		return "redirect:/showItems";
	}


	public void deleteCart(){
		cart = null;
	}
	
	public void resetLoggedOn(){
		loggedOn = null;
	}
}
