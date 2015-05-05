package com.cerveceroscodigo.spring.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cerveceroscodigo.spring.dao.Customer;
import com.cerveceroscodigo.spring.dao.Post;
import com.cerveceroscodigo.spring.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService customers;

	/**
	 * Denne metoden viser registreringssiden for der kunden kan registrere seg.
	 * Den har to attributter som "holder" på dataene. Det vil si at om validering 
	 * ikke fullfører så sendes man tilbake, med ferdigutfylte felter, med eventuelle feilmeldinger.
	 * @param model
	 * @return
	 */
	@RequestMapping("/displayRegistration")
	public String displayRegistration(Model model){
		model.addAttribute("post", new Post());
		model.addAttribute("customer", new Customer());
		return "registercustomer";
	}
	
	/**
	 * Denne metoden kjøres i det man submitter customer registration form.
	 * Den validerer Customer via Customer.java sine valideringsregler.
	 * Hvis det er OK så sendes man til "registered.jsp" som fullført!
	 * HVis ikke, så havner man tilbake til registreringsskjemaet.
	 * @param model
	 * @param customer
	 * @param result
	 * @return
	 */
	@RequestMapping(value="/registercustomer", method=RequestMethod.POST)
	public String registerCustomer(Model model, @Valid Customer customer, BindingResult result){
		
		if(!result.hasErrors()){
			if(customers.createCustomer(customer)){
				return "registered";	
			}
		}
		return "registercustomer";
	}
	
	@RequestMapping(value="/findcustomer")
	public String getCustomerByID(Model model, int id){
		
		Customer c = customers.getCustomerById(id);
		if(c != null)
			model.addAttribute("customer", c);
		return "displaycustomer";
	}
	
	@RequestMapping("/showaccount")
	public Customer showAccount(Model model){
		return null;
	}
	
	@RequestMapping("/editaccount")
	public void editCustomer(Model model){
		
	}
	
	@RequestMapping("/orderhistory")
	public void displayOrderHistory(Model model){
		
	}
	
	@RequestMapping("/showcustomers")
	public String displayAllCustomers(Model model){
		List<Customer> list = customers.getCustomers();
		if(list != null)
			model.addAttribute("liste", list);
		return "customers";
	}
	
}
