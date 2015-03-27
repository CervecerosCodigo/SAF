package com.cerveceroscodigo.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {

	@RequestMapping("/")
	public String showHome(Model model){
		
		model.addAttribute("name", "Boris");
		return "home";
	}

}
