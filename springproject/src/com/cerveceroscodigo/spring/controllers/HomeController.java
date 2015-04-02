package com.cerveceroscodigo.spring.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cerveceroscodigo.spring.dao.Item;
import com.cerveceroscodigo.spring.dao.Post;
import com.cerveceroscodigo.spring.dao.PriceHistory;
import com.cerveceroscodigo.spring.service.ItemService;
import com.cerveceroscodigo.spring.service.PersonService;
import com.cerveceroscodigo.spring.service.PostService;
import com.cerveceroscodigo.spring.service.PriceHistoryService;

@Controller
public class HomeController {

	@Autowired
	private PostService postService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private PriceHistoryService historyService;
	@Autowired
	private PersonService personService;
	
	
	
	@RequestMapping("/")
	public String showHome(Model model){
		
		List<Post> post = postService.showAllPost();
		model.addAttribute("post", post);
		
		//model.addAttribute("name", "Boris");
		
//		Item item = new Item("BIKE", "Electric 48V ", 450.00, 2);
//		itemService.create(item);
		List<Item> items = itemService.showAllItems();
		model.addAttribute("items", items);
		
		
		//Alt nedenfor er under test..
//		Date d = Calendar.getInstance().getTime();
//		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		String dateString = dateFormat.format(d);
//		PriceHistory capHistory = new PriceHistory(0, dateString, 20.0);
//		historyService.create(capHistory);
//		model.addAttribute("history", capHistory);
		
		
//		Person p = new Person("Truls", "Larsen", "Osloveien 1", "", "1234", "23002300", "truls@online.no", "123468", 1);
//		personService.createPerson(p);
		
		return "home";
	}

}
