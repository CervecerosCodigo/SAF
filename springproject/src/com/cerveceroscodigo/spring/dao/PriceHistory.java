package com.cerveceroscodigo.spring.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="price_history")
public class PriceHistory {

	@Id
	@Column(name="iditem")
	private int idItem;
	
	@Column(name="date")
	private String dateChanged;
	
	@Column(name="old_price")
	private double oldPrice;

	@ManyToOne
	@JoinColumn(name="id")
	private Item item;
	
	
	public PriceHistory(int idItem, String dateChanged, double oldPrice) {
		super();
		this.idItem = idItem;
		this.dateChanged = dateChanged;
		this.oldPrice = oldPrice;
	}

	public PriceHistory() {
	}

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public String getDateChanged() {
		return dateChanged;
	}

	public void setDateChanged(String dateChanged) {
		this.dateChanged = dateChanged;
	}

	public double getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(double oldPrice) {
		this.oldPrice = oldPrice;
	}

	@Override
	public String toString() {
		return "PriceHistory [idItem=" + idItem + ", dateChanged="
				+ dateChanged + ", oldPrice=" + oldPrice + "]";
	}

}
