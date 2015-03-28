package com.cerveceroscodigo.spring.dao;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component("personTypeDao")
public class PersonTypeDao {

	private NamedParameterJdbcTemplate jdbc;

	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setDatasource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	
	public Session session(){
		return sessionFactory.getCurrentSession();
	}
}
