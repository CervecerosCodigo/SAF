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
@Component("customerDao")
public class CustomerDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public Session session(){
		return sessionFactory.getCurrentSession();
	}

	
	//from Person er referanse til Java-klasse, ikke database
	@SuppressWarnings("unchecked")
	public List<Customer> getCustomer(){
		return session().createQuery("from Customer").list();
	}
	
	public Customer getCustomer(int id){
		return findCustomerById(id);
	}
	
	public void createCustomer(Customer customer){
		session().save(customer);
	}
	
	public boolean deleteCustomer(int id){
		Customer c = findCustomerById(id);
		if(c != null){
			session().delete(c);
			return true;
		}else
			return false;
	}
	
	public boolean updateCustomer(Customer customer){
		return false;
	}
	
	public boolean exists(int id){
		Customer c = findCustomerById(id);
		return c != null;
	}
	
	
	private Customer findCustomerById(int id){
		Criteria crit = session().createCriteria(Item.class);
		crit.add(Restrictions.idEq(id));
		Customer c = (Customer)crit.uniqueResult();
		return c;		
	}
}
