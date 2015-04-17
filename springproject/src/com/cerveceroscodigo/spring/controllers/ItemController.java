package com.cerveceroscodigo.spring.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cerveceroscodigo.spring.dao.Item;

@Controller
public class ItemController {

	@RequestMapping("createItem")
	public void createItem(Model model){
		
	}
	
	@RequestMapping("displayItem")
	public Item displayItem(Model model){
		return null;
	}
	
	@RequestMapping("displayAllItems")
	public List<Item> showAllItems(){
		return null;
	}
	
	@RequestMapping("deleteItem")
	public void deleteItem(Model model){
		
	}
}
