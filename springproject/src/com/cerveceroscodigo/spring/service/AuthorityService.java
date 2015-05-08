package com.cerveceroscodigo.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerveceroscodigo.spring.dao.Authority;
import com.cerveceroscodigo.spring.dao.AuthorityDao;

@Service("authorityService")
public class AuthorityService {

	private AuthorityDao authorityDao;


	@Autowired
	public void setAuthorityDao(AuthorityDao authorityDao) {
		this.authorityDao = authorityDao;
	}



	public void create(Authority a){
		authorityDao.create(a);
	}

	public boolean exists(String  epost){
		return authorityDao.exists(epost);
	}
	
	public void updateAuthority(Authority a, String orgUsername){
		authorityDao.updateAuthority(a, orgUsername);
	}
}
