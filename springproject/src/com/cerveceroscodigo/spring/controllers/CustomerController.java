package com.cerveceroscodigo.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cerveceroscodigo.spring.dao.Customer;

@Controller
public class CustomerController {


	@RequestMapping("register")
	public void regsiterCustomer(Model model){
		
	}
	
	@RequestMapping("account")
	public Customer showCustomer(Model model){
		return null;
	}
	
	@RequestMapping("changepassword")
	public void editCustomer(Model model){
		
	}
	
	
	
}
