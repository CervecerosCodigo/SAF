package com.cerveceroscodigo.spring.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cerveceroscodigo.spring.dao.Authority;
import com.cerveceroscodigo.spring.dao.Cart;
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
		model.addAttribute("user", new User());
		
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
			
			Authority auth = new Authority();
			auth.setUsername(customer.getEmail());
			auth.setAuthority("customer");
			
			User user = new User();
			user.setPassword("letmein");
			user.setUsername(customer.getEmail());
			user.setEnabled(1);
			
			System.out.println(customer);
			System.out.println(auth);
			System.out.println(user);
			
			if(!authorities.exists(auth.getUsername()))
				authorities.create(auth);
			if(!users.exists(user.getUsername()))
				users.create(user);
			
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
	public String showAccount(Model model){
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
	
}
