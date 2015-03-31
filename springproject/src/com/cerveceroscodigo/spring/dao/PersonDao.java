package com.cerveceroscodigo.spring.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@Component("personsDao")
public class PersonDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public Session session(){
		return sessionFactory.getCurrentSession();
	}

	
	//from Person er referanse til Java-klasse, ikke database
	@SuppressWarnings("unchecked")
	public List<Person> getPersons(){
		return session().createQuery("from Person").list();
	}
	
	public Person getPerson(int id){
		return null;
	}
	
	public void createPerson(Person person){
		session().save(person);
	}
	
	public boolean deletePerson(int id){
		return false;
	}
	
	public boolean updatePerson(Person person){
		return false;
	}
}
