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
@Component("authorityDao")
public class AuthorityDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session session(){
		return sessionFactory.getCurrentSession();
	}
	
	public void create(Authority a){
		session().save(a);
	}
	
	public boolean exists(String epost){
		Criteria crit = session().createCriteria(Authority.class);
		crit.add(Restrictions.idEq(epost));
		Authority a = (Authority) crit.uniqueResult();
		return a != null;
	}
	
	public void updateAuthority(Authority a, String orgUsername){
		
		session().update(a);
	}
	
	public Authority findAuthorityByEmail(String email){
		Criteria crit = session().createCriteria(Authority.class);
		crit.add(Restrictions.idEq(email));
		Authority a = (Authority)crit.uniqueResult();
		return a;
	}
	
}
