package com.cerveceroscodigo.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerveceroscodigo.spring.dao.EmploymentDao;
import com.cerveceroscodigo.spring.dao.Person;
import com.cerveceroscodigo.spring.dao.PersonDao;

@Service("personService")
public class PersonService {

	private PersonDao personDao;
	private EmploymentDao employmentDao;

	
	@Autowired
	public void setEmploymentDao(EmploymentDao employmentDao) {
		this.employmentDao = employmentDao;
	}


	@Autowired
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}


	public void createPerson(Person person){
		personDao.createPerson(person);
		
	}
	
	
}
