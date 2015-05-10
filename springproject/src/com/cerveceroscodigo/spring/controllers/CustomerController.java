package com.cerveceroscodigo.spring.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
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
import com.cerveceroscodigo.spring.dao.Item;
import com.cerveceroscodigo.spring.dao.OrderLines;
import com.cerveceroscodigo.spring.dao.Orders;
import com.cerveceroscodigo.spring.dao.Post;
import com.cerveceroscodigo.spring.dao.User;
import com.cerveceroscodigo.spring.service.AuthorityService;
import com.cerveceroscodigo.spring.service.CustomerService;
import com.cerveceroscodigo.spring.service.ItemService;
import com.cerveceroscodigo.spring.service.OrdersService;
import com.cerveceroscodigo.spring.service.UserService;

@Controller
public class CustomerController {

	@Autowired
	private ItemService itemService;
	@Autowired
	private OrdersService orderService;
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

			try{
				if(!authorities.exists(auth.getUsername())){
					authorities.create(auth);
					throw new CustomErrorException("The username is already accociated with a role");
				}
				if(!users.exists(user.getUsername())){
					users.create(user);
					throw new CustomErrorException("The username exists");
				}
				if(customers.createCustomer(customer)){
					return "registered";	
				}
			}catch(CustomErrorException e){
				model.addAttribute("exists", e.getMessage());
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
	
	
	@RequestMapping(value="/checkout")
	public String checkoutCart(Model model, HttpSession session, Principal principal){
		String username = principal.getName();
		Customer c = customers.getCustomerByUsername(username);
		
		Cart cart = (Cart) session.getAttribute("cart");
		
		if(c != null){
			model.addAttribute("customer", c);
		}
		
		return "checkout";
	}

	
	@RequestMapping(value="/confirmingOrder")
	public String confirmingOrder(Model model, HttpSession session, Principal principal){
		
		String username = principal.getName();
		Customer customer = customers.getCustomerByUsername(username);
		Orders order = new Orders(customer.getIdCustomer(), new Date(), new ArrayList<>());
		orderService.createOrder(order);	//Oppretter order

		Cart c = (Cart)session.getAttribute("cart");
		List<Item>list = c.getCartItems();
		for(Item item : list){
			OrderLines line = new OrderLines(item.getId(), order.getIdOrder(), item.getPriceIn(), 1);
			order.addOrderLine(line);	//add
		}
		
		orderService.updateOrder(order);
		
		return "allDone";
	}
	
	
	@RequestMapping(value="/editaccount", method=RequestMethod.POST)
	public String editCustomer(Model model, @Valid Customer customer, BindingResult result, Principal principal){
		String loggedOn = principal.getName();

		if(!result.hasErrors()){
			customers.updateCustomer(customer, loggedOn);
			
			Authority auth = generateAuthorityFromCustomer(customer);
			User user = generateUserFromCustomer(customer);
			
			/**
			 * The following two doesn't work with email update.!!
			 * **/
			authorities.updateAuthority(auth, loggedOn);
			users.updateUser(user, loggedOn);
			
		}
		return "showaccount";
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
