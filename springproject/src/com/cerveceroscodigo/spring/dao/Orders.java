package com.cerveceroscodigo.spring.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="orders")
public class Orders {

	@Id
	@GeneratedValue
	@Column(name="idorder")
	private int idOrder;
	
	@Column(name="idperson")
	private int idPerson;
	
	@Column(name="order_date")
	private Date orderDate;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="idorder")
	private List<OrderLines> orderLines;

	public Orders(int idOrder, int idPerson, Date orderDate,
			List<OrderLines> orderLines) {
		super();
		this.idOrder = idOrder;
		this.idPerson = idPerson;
		this.orderDate = orderDate;
		this.orderLines = orderLines;
	}
	public Orders(int idPerson, Date orderDate,
			List<OrderLines> orderLines) {
		super();
		this.idPerson = idPerson;
		this.orderDate = orderDate;
		this.orderLines = orderLines;
	}
	

	public Orders(){
		
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


	public List<OrderLines> getOrderLines() {
		return orderLines;
	}


	public void setOrderLines(List<OrderLines> orderLines) {
		this.orderLines = orderLines;
	}

	
	public void addOrderLine(OrderLines line){
		if(orderLines == null)
			orderLines = new ArrayList<OrderLines>();
		orderLines.add(line);
	}

	@Override
	public String toString() {
		return "Orders [idOrder=" + idOrder + ", idPerson=" + idPerson
				+ ", orderDate=" + orderDate + ", orderLines=" + orderLines
				+ "]";
	}
	
	
	

}
