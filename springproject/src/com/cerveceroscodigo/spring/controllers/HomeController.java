package com.cerveceroscodigo.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cerveceroscodigo.spring.dao.Customer;
import com.cerveceroscodigo.spring.dao.Item;
import com.cerveceroscodigo.spring.dao.Post;
import com.cerveceroscodigo.spring.service.CustomerService;
import com.cerveceroscodigo.spring.service.ItemService;
import com.cerveceroscodigo.spring.service.PostService;

@Controller
public class HomeController {

	@Autowired
	private PostService postService;
	
	@Autowired
	private ItemService itemService;
	@Autowired
	private CustomerService customerService;
	
	
	
	@RequestMapping("/")
	public String showHome(Model model){
		
		List<Post> post = postService.showAllPost();
		model.addAttribute("post", post);
		
		List<Item> items = itemService.showAllItems();
		model.addAttribute("items", items);
		
		Post p = new Post("1100", "Oslo");
		Customer c = new Customer("Anders", "Jacobsen", "Drammensveien 1", "", "90054600", "anders@online.no", "123468", p);
		customerService.createCustomer(c);
		
		return "home";
	}

}
