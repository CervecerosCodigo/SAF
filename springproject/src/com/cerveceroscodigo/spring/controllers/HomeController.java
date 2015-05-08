package com.cerveceroscodigo.spring.controllers;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cerveceroscodigo.spring.dao.Customer;
import com.cerveceroscodigo.spring.dao.Item;
import com.cerveceroscodigo.spring.dao.OrderLines;
import com.cerveceroscodigo.spring.dao.Orders;
import com.cerveceroscodigo.spring.service.CustomerService;
import com.cerveceroscodigo.spring.service.ItemService;
import com.cerveceroscodigo.spring.service.OrdersService;
import com.cerveceroscodigo.spring.service.PostService;

@Controller
public class HomeController {

	@Autowired
	private PostService postService;
	
	@Autowired
	private ItemService itemService;
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private OrdersService orderService;
	
	@RequestMapping("/")
	public String showHome(Model model){
		
//		Item item = itemService.getItemById(1);	//Get item
//		Customer customer = customerService.getCustomerByUsername("demo@test.no");
//		
//		Orders order = new Orders(customer.getIdCustomer(), new Date(), new ArrayList<>());
//		orderService.createOrder(order);	//Oppretter order
//
//		OrderLines line = new OrderLines(item.getId(), order.getIdOrder(), item.getPriceIn(), 1);
//
//		
//		order.addOrderLine(line);	//add
//		orderService.updateOrder(order);
		
		
		return "home";
	}

}
