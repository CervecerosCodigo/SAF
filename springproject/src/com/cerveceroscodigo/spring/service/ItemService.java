package com.cerveceroscodigo.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cerveceroscodigo.spring.dao.Item;
import com.cerveceroscodigo.spring.dao.ItemDao;


@Service("itemService")
public class ItemService {

	private ItemDao itemDao;

	@Autowired
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
	
	public List<Item> showAllItems(){
		return itemDao.showAllItems();
	}
	
	public void create(Item item){
		itemDao.create(item);
	}
	
	public boolean exists(int id){
		return itemDao.exists(id);
	}
	
}
