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

	@RequestMapping(value = "/registeritem", method = RequestMethod.POST)
	public String createItem(Model model, @Valid Item item, BindingResult result) {

		if (!result.hasErrors()) {
			items.create(item); //@TODO: Denne må endres til at den returnerer boolen
			return "registereditem"; // ref to page if registered
		}
		return "registeritem"; // ref to the regsitering page
	}

	@RequestMapping(value = "/registeritem", method = RequestMethod.GET)
	public String displayItemRegistration(Model model, @Valid Item item, BindingResult result) {

		model.addAttribute("item", new Item());
		return "registeritem"; // ref to the regsitering page
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
