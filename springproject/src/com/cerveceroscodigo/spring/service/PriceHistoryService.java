package com.cerveceroscodigo.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerveceroscodigo.spring.dao.PriceHistory;
import com.cerveceroscodigo.spring.dao.PriceHistoryDao;

@Service("priceHstoryService")
public class PriceHistoryService {

	private PriceHistoryDao priceHistoryDao;

	@Autowired
	public void setPriceHistoryDao(PriceHistoryDao priceHistoryDao) {
		this.priceHistoryDao = priceHistoryDao;
	}

	public List<PriceHistory> showAllHistory(){
		return priceHistoryDao.showAllHistory();
	}
	
	public void create(PriceHistory history){
		priceHistoryDao.create(history);
	}
	
}
