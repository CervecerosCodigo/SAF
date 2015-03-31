package com.cerveceroscodigo.spring.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="person_type")
public class PersonType {

	@Id
	@GeneratedValue
	@Column(name="idperson_type")
	private int id;
	
	@Column(name="type")
	private String type;
	
	public PersonType(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
	
	public PersonType(){
		
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "PersonType [id=" + id + ", type=" + type + "]";
	}
	
	
}
