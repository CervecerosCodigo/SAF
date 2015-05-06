package com.cerveceroscodigo.spring.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@Component("userDao")
public class UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session session(){
		return sessionFactory.getCurrentSession();
	}
	
	public void create(User u){
		session().save(u);
	}
	
	public boolean exists(String epost){
		Criteria crit = session().createCriteria(User.class);
//		crit.add(Restrictions.eq("postNumber", postNr));
		crit.add(Restrictions.idEq(epost));
		User u = (User) crit.uniqueResult();
		return u != null;
	}
}
