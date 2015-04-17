package com.cerveceroscodigo.spring.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class Item {

	@Id
	@GeneratedValue
	@Column(name="iditem")
	private int id;
	
	@Column(name="type")
	private String type;
	
	@Column(name="description")
	private String description;
	
	@Column(name="price_in")
	private double priceIn;
	
	@Column(name="num_instock")
	private int numInStock;

	public Item(String type, String description, double priceIn,
			int numInStock, int changedBy) {
		super();
		
		this.type = type;
		this.description = description;
		this.priceIn = priceIn;
		this.numInStock = numInStock;
	}

	public Item() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPriceIn() {
		return priceIn;
	}

	public void setPriceIn(double priceIn) {
		this.priceIn = priceIn;
	}

	public int getNumInStock() {
		return numInStock;
	}

	public void setNumInStock(int numInStock) {
		this.numInStock = numInStock;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", type=" + type + ", description="
				+ description + ", priceIn=" + priceIn + ", numInStock="
				+ numInStock + ", changedBy=" + "]";
	}

	

}
