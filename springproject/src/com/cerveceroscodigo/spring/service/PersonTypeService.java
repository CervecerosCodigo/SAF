package com.cerveceroscodigo.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerveceroscodigo.spring.dao.PersonTypeDao;


@Service("personTypeService")
public class PersonTypeService {

	private PersonTypeDao personTypeDao;

	@Autowired
	public void setPersonTypeDao(PersonTypeDao personTypeDao) {
		this.personTypeDao = personTypeDao;
	}


	
	
}
