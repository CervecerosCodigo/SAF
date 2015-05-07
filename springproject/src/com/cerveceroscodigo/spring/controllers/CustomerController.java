package com.cerveceroscodigo.spring.controllers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cerveceroscodigo.spring.dao.Authority;
import com.cerveceroscodigo.spring.dao.Customer;
import com.cerveceroscodigo.spring.dao.Post;
import com.cerveceroscodigo.spring.dao.User;
import com.cerveceroscodigo.spring.service.AuthorityService;
import com.cerveceroscodigo.spring.service.CustomerService;
import com.cerveceroscodigo.spring.service.UserService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService customers;
	@Autowired
	AuthorityService authorities;
	@Autowired
	UserService users;
	
	
	/**
	 * Denne metoden viser registreringssiden for der kunden kan registrere seg.
	 * Den har to attributter som "holder" på dataene. Det vil si at om validering 
	 * ikke fullfører så sendes man tilbake, med ferdigutfylte felter, med eventuelle feilmeldinger.
	 * @param model
	 * @return
	 */
	@RequestMapping("/displayUserRegistration")
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
			
			//Checks if username exists, and notifies customer if it does
			if(customers.exists(customer.getEmail())){
				model.addAttribute("exists", "The username exists, try another one!");
				return "registercustomer";
			}
			
			Authority auth = generateAuthorityFromCustomer(customer);
			User user = generateUserFromCustomer(customer);

			
			if(!authorities.exists(auth.getUsername()))
				authorities.create(auth);
			
			if(!users.exists(user.getUsername()))
				users.create(user);
			
			if(customers.createCustomer(customer)){
				return "registered";	
			}
		}
		//Errors in validation has occured. Returning to registration form
		return "registercustomer";
	}
	
	@RequestMapping(value="/findcustomer")
	public String getCustomerByUsername(Model model, String username){
		Customer c = customers.getCustomerByUsername(username);
		if(c != null)
			model.addAttribute("customer", c);
		return "displaycustomer";
	}
	
	@RequestMapping(value="/showaccount", method=RequestMethod.GET)
	public String showAccount(Model model, Principal principal){
		String username = principal.getName();
		Customer c = customers.getCustomerByUsername(username);
		if(c != null){
			model.addAttribute("customer", c);
		}
		return "showaccount";
	}

	
	@RequestMapping("/editaccount")
	public void editCustomer(Model model){
		
	}
	
	@RequestMapping("/orderhistory")
	public void displayOrderHistory(Model model){
		
	}
	
	@RequestMapping("/showCustomers")
	public String displayAllCustomers(Model model){
		List<Customer> list = customers.getCustomers();
		if(list != null)
			model.addAttribute("liste", list);
		return "customers";
	}
	
	
	
	private Authority generateAuthorityFromCustomer(Customer c){
		Authority auth = new Authority();
		auth.setUsername(c.getEmail());
		auth.setAuthority("ROLE_USER");	//Hard coding authority for customer
		return auth;
	}
	
	private User generateUserFromCustomer(Customer c){
		User user = new User();
		user.setPassword(c.getPassword());
		user.setUsername(c.getEmail());
		user.setEnabled(1);
		return user;
	}
}
