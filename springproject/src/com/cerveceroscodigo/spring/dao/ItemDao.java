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
@Component("itemDao")
public class ItemDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session session(){
		return sessionFactory.getCurrentSession();
	}
	
	
	@Transactional
	public void create(Item item){
		session().save(item);
	}
	
	@SuppressWarnings("unchecked")
	public List<Item> showAllItems(){
		return session().createQuery("from Item").list();
	}
	
	public boolean exists(int id){
		Criteria crit = session().createCriteria(Item.class);
		crit.add(Restrictions.idEq(id));
		Item it = (Item)crit.uniqueResult();
		return it != null;
	}
	
	public Item getItemById(int id){
		Criteria crit = session().createCriteria(Item.class);
		crit.add(Restrictions.idEq(id));
		Item it = (Item)crit.uniqueResult();
		return it;
	}
	
	public void updateItem(Item item){
		session().update(item);
	}
	
}
