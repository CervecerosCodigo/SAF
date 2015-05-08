package com.cerveceroscodigo.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerveceroscodigo.spring.dao.Orders;
import com.cerveceroscodigo.spring.dao.OrdersDao;

@Service("ordersService")
public class OrdersService {

	private OrdersDao ordersDao;

	@Autowired
	public void setOrdersDao(OrdersDao ordersDao) {
		this.ordersDao = ordersDao;
	}

	
	public List<Orders> getOrders(){
		return ordersDao.getOrders();
	}
	
	public void createOrder(Orders order){
		ordersDao.createOrder(order);
	}
	
	public void updateOrder(Orders order){
		ordersDao.updateOrder(order);
	}
}
