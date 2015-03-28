package com.cerveceroscodigo.spring.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employment")
public class Employment {

	@Id
	@Column(name="idperson")
	private int id;
	
	@Column(name="position")
	private String position;

	public Employment(int id, String position) {
		super();
		this.id = id;
		this.position = position;
	}

	public Employment() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Employment [id=" + id + ", position=" + position + "]";
	}

}
