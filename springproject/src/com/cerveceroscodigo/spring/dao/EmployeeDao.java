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
@Component("employeeDao")
public class EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public Session session(){
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public List<Employee> getEmployees(){
		return session().createQuery("from Employee").list();
	}
	
	public Employee getEmployee(int id){
		return null;
	}
	
	public void createEmployee(Employee employee){
		session().save(employee);
	}
	
	public boolean deleteEmployee(int id){
		return false;
	}
	
	public boolean updateEmployee(Employee employee){
		return false;
	}
}
