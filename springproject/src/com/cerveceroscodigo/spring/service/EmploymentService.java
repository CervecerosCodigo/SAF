package com.cerveceroscodigo.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerveceroscodigo.spring.dao.EmploymentDao;

@Service("employmentService")
public class EmploymentService {

	private EmploymentDao employmentDao;

	@Autowired
	public void setEmploymentDao(EmploymentDao employmentDao) {
		this.employmentDao = employmentDao;
	}
	
	
}
