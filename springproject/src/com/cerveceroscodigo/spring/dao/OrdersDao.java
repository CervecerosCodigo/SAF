package com.cerveceroscodigo.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@Component("ordersDao")
public class OrdersDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session session(){
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<Orders> getOrders(){
		return session().createQuery("from Orders").list();
	}
	
	public void createOrder(Orders order){
		session().save(order);
	}
	
	public void updateOrder(Orders order){
		session().update(order);
	}
}
