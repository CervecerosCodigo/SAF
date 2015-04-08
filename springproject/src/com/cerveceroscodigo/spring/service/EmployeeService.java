package com.cerveceroscodigo.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerveceroscodigo.spring.dao.Employee;
import com.cerveceroscodigo.spring.dao.EmployeeDao;


@Service("employeeService")
public class EmployeeService {


	private EmployeeDao employeeDao;

	@Autowired
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public void createEmployee(Employee employee){
		employeeDao.createEmployee(employee);
	}
}
