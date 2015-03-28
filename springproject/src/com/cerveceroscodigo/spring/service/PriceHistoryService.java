package com.cerveceroscodigo.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerveceroscodigo.spring.dao.PriceHistoryDao;

@Service("priceHstoryService")
public class PriceHistoryService {

	private PriceHistoryDao priceHistoryDao;

	@Autowired
	public void setPriceHistoryDao(PriceHistoryDao priceHistoryDao) {
		this.priceHistoryDao = priceHistoryDao;
	}

	
}
