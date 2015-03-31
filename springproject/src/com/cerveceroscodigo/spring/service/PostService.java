package com.cerveceroscodigo.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerveceroscodigo.spring.dao.Post;
import com.cerveceroscodigo.spring.dao.PostDao;


/**
 * Denne klassen speiler på en måte Dao-klassens metoder.
 * Det er denne klassen som brukes i kontrollerne og innholdet herfra
 * blir sendt til jsp-filene. 
 *
 */

@Service("postService")
public class PostService {

	private PostDao postDao;

	@Autowired
	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}
	
	public List<Post> showAllPost(){
		return postDao.showAllPost();
	}
	
	public void create(Post post){
		postDao.create(post);
	}
}
