package com.cerveceroscodigo.spring.service;

import java.util.List;

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


	public boolean createCustomer(Customer customer){
		return customerDao.createCustomer(customer);
		
	}
	
	public List<Customer> getCustomers(){
		return customerDao.getCustomers();
	}
	
	public boolean deleteCustomer(int id){
		return customerDao.deleteCustomer(id);
	}
	
	public boolean updateCustomer(Customer customer){
		return customerDao.updateCustomer(customer);
	}
	
	public boolean exists(int id){
		return customerDao.exists(id);
	}
	
}
