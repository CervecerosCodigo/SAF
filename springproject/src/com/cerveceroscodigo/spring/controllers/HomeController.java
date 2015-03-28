package com.cerveceroscodigo.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cerveceroscodigo.spring.dao.Post;
import com.cerveceroscodigo.spring.service.PostService;

@Controller
public class HomeController {

	@Autowired
	private PostService postService;
	
	
	@RequestMapping("/")
	public String showHome(Model model){
		
		List<Post> post = postService.getPost();
		model.addAttribute("post", post);
		
		model.addAttribute("name", "Boris");
		return "home";
	}

}
