package com.cerveceroscodigo.spring.controllers;

import java.util.List;

import javax.validation.Valid;

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
	ItemService items;
	Cart cart;


	@RequestMapping(value = "/registerItem", method = RequestMethod.GET)
	public String displayItemRegistration(Model model) {

		model.addAttribute("item", new Item());
		return "registerItem";
	}

	
	@RequestMapping(value = "/registerItem", method = RequestMethod.POST)
	public String createItem(Model model, @Valid Item item, BindingResult result) {
		System.out.println("createItem");
		if (!result.hasErrors()) {
			items.create(item); //@TODO: Denne må endres til at den returnerer boole
			return "registeredItem"; // ref to page if registered
		}
		return "registerItem"; // ref to the regsitering page
	}

	
	@RequestMapping("displayItem")
	public Item displayItem(Model model) {
		return null;
	}

	@RequestMapping(value="/showItems", method = RequestMethod.GET)
	public String showAllItems(Model model, @ModelAttribute Item item) {
		List<Item> list = items.showAllItems();
		if(list != null)
			model.addAttribute("liste", list);
		if(cart == null){
			System.out.println("Legger til en ny vogn");
			cart = new Cart();
			model.addAttribute("cart", cart);
		}else{
			model.addAttribute("cart", cart);
			System.out.println("Det finnes en kundevogn fra før.");
			
			/*
			 * Her kan det i teorien komme kode som legger ting i kundevognen
			 */
			//cart.addToCart(new Item());
			cart.addToCart(item);
			
			System.out.println("Content of the cart:");
			System.out.println(cart.toString());
		}
		return "showItems";
	}

	@RequestMapping("deleteItem")
	public void deleteItem(Model model) {

	}
}
