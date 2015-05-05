package com.cerveceroscodigo.spring.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cerveceroscodigo.spring.dao.Item;
import com.cerveceroscodigo.spring.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	ItemService items;


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
			return "registered"; // ref to page if registered
		}
		return "registerItem"; // ref to the regsitering page
	}

	
	@RequestMapping("displayItem")
	public Item displayItem(Model model) {
		return null;
	}

	@RequestMapping("displayAllItems")
	public List<Item> showAllItems() {
		return null;
	}

	@RequestMapping("deleteItem")
	public void deleteItem(Model model) {

	}
}
