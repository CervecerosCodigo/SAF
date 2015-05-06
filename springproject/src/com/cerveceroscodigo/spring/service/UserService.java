package com.cerveceroscodigo.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerveceroscodigo.spring.dao.User;
import com.cerveceroscodigo.spring.dao.UserDao;

@Service("userService")
public class UserService {

	private UserDao userDao;

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void create(User u){
		userDao.create(u);
	}
	
	public boolean exists(String epost){
		return userDao.exists(epost);
	}
}
