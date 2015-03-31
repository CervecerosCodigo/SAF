package com.cerveceroscodigo.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cerveceroscodigo.spring.dao.Person;
import com.cerveceroscodigo.spring.dao.Post;
import com.cerveceroscodigo.spring.service.PersonService;
import com.cerveceroscodigo.spring.service.PostService;

@Controller
public class HomeController {

	@Autowired
	private PostService postService;
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping("/")
	public String showHome(Model model){
		
		List<Post> post = postService.showAllPost();
		model.addAttribute("post", post);
		
		model.addAttribute("name", "Boris");
		
		
//		Person p = new Person("Truls", "Larsen", "Osloveien 1", "", "1234", "23002300", "truls@online.no", "123468", 1);
//		personService.createPerson(p);
		
		return "home";
	}

}
