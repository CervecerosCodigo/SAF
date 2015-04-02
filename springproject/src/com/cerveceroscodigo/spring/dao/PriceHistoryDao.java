package com.cerveceroscodigo.spring.dao;

import java.util.List;

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
@Component("priceHistoryDao")
public class PriceHistoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session session(){
		return sessionFactory.getCurrentSession();
	}
	
	@Transactional
	public void create(PriceHistory history){
		session().save(history);
	}
	
	@SuppressWarnings("unchecked")
	public List<PriceHistory> showAllHistory(){
		Criteria crit = session().createCriteria(PriceHistory.class);
		crit.createAlias("item", "it").add(Restrictions.eq("it.enabled", true));
		return crit.list();
	}
	
}
