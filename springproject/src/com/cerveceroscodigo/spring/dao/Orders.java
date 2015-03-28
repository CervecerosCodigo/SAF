package com.cerveceroscodigo.spring.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Orders {

	@Id
	@Column(name="idorder")
	private int idOrder;
	
	@Column(name="idperson")
	private int idPerson;
	
	@Column(name="order_date")
	private Date orderDate;

	public Orders(int idOrder, int idPerson, Date orderDate) {
		super();
		this.idOrder = idOrder;
		this.idPerson = idPerson;
		this.orderDate = orderDate;
	}

	public Orders() {

	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public int getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "Orders [idOrder=" + idOrder + ", idPerson=" + idPerson
				+ ", orderDate=" + orderDate + "]";
	}

}
