package com.cerveceroscodigo.spring.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("personsDao")
public class PersonDAO {

	
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDatasource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	
	public List<Person> getPersons(){
		return null;
	}
	
	public Person getPerson(int id){
		return null;
	}
	
	public boolean createPerson(Person person){
		return false;
	}
	
	public boolean deletePerson(int id){
		return false;
	}
	
	public boolean updatePerson(Person person){
		return false;
	}
}
