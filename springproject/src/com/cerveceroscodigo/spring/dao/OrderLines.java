package com.cerveceroscodigo.spring.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order_line")
public class OrderLines implements Serializable{

	@Id
	@Column(name="iditem")
	private int idItem;
	
	@Id
	@Column(name="idorder")
	private int idOrder; 
	
	@Column(name="price_unit")
	private double priceUnit;
	
	@Column(name="amount")
	private int amount;

	public OrderLines(int idItem, int idOrder, double priceUnit, int amount) {
		super();
		this.idItem = idItem;
		this.idOrder = idOrder;
		this.priceUnit = priceUnit;
		this.amount = amount;
	}
	
	
	public OrderLines(){
		
	}


	public int getIdItem() {
		return idItem;
	}


	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}


	public int getIdOrder() {
		return idOrder;
	}


	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}


	public double getPriceUnit() {
		return priceUnit;
	}


	public void setPriceUnit(double priceUnit) {
		this.priceUnit = priceUnit;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	@Override
	public String toString() {
		return "OrderLines [idItem=" + idItem + ", idOrder=" + idOrder
				+ ", priceUnit=" + priceUnit + ", amount=" + amount + "]";
	}
	
	
}
