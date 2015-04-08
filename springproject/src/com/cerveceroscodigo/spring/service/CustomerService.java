package com.cerveceroscodigo.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerveceroscodigo.spring.dao.Customer;
import com.cerveceroscodigo.spring.dao.CustomerDao;

@Service("customerService")
public class CustomerService {

	private CustomerDao customerDao;
	
	@Autowired
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}


	public void createCustomer(Customer customer){
		customerDao.createCustomer(customer);
		
	}
	
	
}
