package com.cerveceroscodigo.spring.dao;

import java.util.Calendar;

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
	private Calendar dateChanged;
	
	@Column(name="old_price")
	private double oldPrice;

	
	@Column(name="emp_idemp")
	private int changedBy;
	
	@ManyToOne
	@JoinColumn(name="id")
	private Item item;
	
	
	
	public PriceHistory(int idItem, Calendar dateChanged, double oldPrice, int changedBy) {
		super();
		this.idItem = idItem;
		this.dateChanged = dateChanged;
		this.oldPrice = oldPrice;
		this.changedBy = changedBy;
	}

	public PriceHistory() {
	}

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public Calendar getDateChanged() {
		return dateChanged;
	}

	public void setDateChanged(Calendar dateChanged) {
		this.dateChanged = dateChanged;
	}

	public double getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(double oldPrice) {
		this.oldPrice = oldPrice;
	}

	
	public int getChangedBy() {
		return changedBy;
	}

	public void setChangedBy(int changedBy) {
		this.changedBy = changedBy;
	}

	@Override
	public String toString() {
		return "PriceHistory [idItem=" + idItem + ", dateChanged="
				+ dateChanged + ", oldPrice=" + oldPrice + ", changedBy="
				+ changedBy + "]";
	}

	
}
