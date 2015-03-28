package com.cerveceroscodigo.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cerveceroscodigo.spring.dao.Post;
import com.cerveceroscodigo.spring.service.PostService;


/**
 * Alle kontrollere som har RequestMapping mot en jsp-fil 
 * og som skal sende/motta data må ha én eller flere "service"-instanser.
 * 
 */

@Controller
public class PostController {

	
	private PostService postService;

	@Autowired
	public void setPostService(PostService postService) {
		this.postService = postService;
	}
	
//	@RequestMapping("/post")
//	public String showPost(Model model){
//		List<Post> post = postService.getPost();
//		model.addAttribute("post", post);
//		return "post";
//	}
	
}
