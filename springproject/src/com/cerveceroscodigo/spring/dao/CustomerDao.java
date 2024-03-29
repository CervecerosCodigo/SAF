package com.cerveceroscodigo.spring.dao;

import java.util.List;

import javax.persistence.criteria.Order;
import javax.validation.Valid;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

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
	public List<Customer> getCustomers(){
		return session().createQuery("from Customer").list();
	}
	
	public Customer getCustomer(int id){
		return findCustomerById(id);
	}
	
	public boolean createCustomer(Customer customer){
		if(findCustomerByEmail(customer.getEmail()) == null){
			session().save(customer);
			return true;
		}
		return false;
	}
	
	public boolean deleteCustomer(int id){
		Customer c = findCustomerById(id);
		if(c != null){
			session().delete(c);
			return true;
		}else
			return false;
	}
	
	/**
	 * To update a customer we need to make sure that the updated object has 
	 * the same id as the one in the database. Otherwise the update will be an insert..
	 * @param customer
	 */
	public void updateCustomer(Customer customer, String orgUsername){
		Customer orgCust = findCustomerByEmail(orgUsername);
		if(orgCust != null){
			int orgCustId = orgCust.getIdCustomer();
			customer.setIdCustomer(orgCustId);
			session().merge(customer);
			
		}
	}
	
	public boolean exists(int id){
		Customer c = findCustomerById(id);
		return c != null;
	}
	
	public boolean exists(String email){
		return findCustomerByEmail(email) != null;
	}
	
	//Helper method, returning Customer object if found by email
	public Customer findCustomerByEmail(String e){
		Criteria crit = session().createCriteria(Customer.class);
		crit.add(Restrictions.eq("email", e));
		Customer c = (Customer)crit.uniqueResult();
		return c;
	}
	
	//Helper method, returning Customer object if found by id
	public Customer findCustomerById(int id){
		Criteria crit = session().createCriteria(Customer.class);
		crit.add(Restrictions.idEq(id));
		Customer c = (Customer)crit.uniqueResult();
		return c;		
	}
	
	public List<Orders> getAllOrders(Customer customer){
		Criteria crit = session().createCriteria(Orders.class);
		crit.add(Restrictions.eq("idPerson", customer.getIdCustomer()));
		List<Orders> list = crit.list();
		return list;
	}
	
}
