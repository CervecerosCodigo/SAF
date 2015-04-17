package com.cerveceroscodigo.spring.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Denne klassen er der man implementerer Hibernate-spørringene. 
 * Se metoden getPost(). 
 * Alle Dao-klasser må ha en sessionFactory.
 *
 */

@Repository
@Transactional
@Component("postDao")
public class PostDao {

	
	@Autowired
	private SessionFactory sessionFactory;

	public Session session(){
		return sessionFactory.getCurrentSession();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Post> showAllPost(){
		return session().createQuery("from Post").list();
	}
	
	/**
	 * Lagrer post-parameteren i databasen.
	 * @param post
	 */
	@Transactional 
	public void create(Post post){
		session().save(post);
	}
	
	/**
	 * Denne metoden sjekker om PostNr finnes i databasen.
	 * Restrictions, inne i crit.add har mange forskjellige tester.
	 * I det utkommenterte tilfellet definerer man feltet postNumber i javaklassen Post.java.
	 * I tilfellet som er i bruk så benyttes primærnøkkelfeltet i databasen mot idEq(postNr)
	 * @param postNr
	 * @return
	 */
	public boolean exists(String postNr){
		Criteria crit = session().createCriteria(Post.class);
//		crit.add(Restrictions.eq("postNumber", postNr));
		crit.add(Restrictions.idEq(postNr));
		Post p = (Post) crit.uniqueResult();
		return p != null;
	}
	
	
}
