package com.cerveceroscodigo.spring.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


/**
 * Denne klassen er der man implementerer Hibernate-spørringene. 
 * Se metoden getPost(). 
 * Alle Dao-klasser må ha en sessionFactory.
 *
 */

@Transactional
@Component("postDao")
public class PostDao {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	private SessionFactory sessionFactory;

	public Session session(){
		return sessionFactory.getCurrentSession();
	}
	
	
	@Autowired
	public void setDatasource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Post> getPost(){
		return session().createQuery("from Post").list();
	}
	

}
