package com.cerveceroscodigo.spring.dao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person {

	@Id
	private int idperson;
	private String firstname;
	private String lastname;
	private String address1;
	private String address2;
	private String post_number;
	private String phone;
	private String email;
	private String password;
	private int person_type;

	
	public Person(){
		
	}
	
	public Person(String firstname, String lastname, String address1,
			String address2, String post_number, String phone, String email,
			String password, int person_type) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.address1 = address1;
		this.address2 = address2;
		this.post_number = post_number;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.person_type = person_type;
	}

	public int getIdperson() {
		return idperson;
	}

	public void setIdperson(int idperson) {
		this.idperson = idperson;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getPost_number() {
		return post_number;
	}

	public void setPost_number(String post_number) {
		this.post_number = post_number;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPerson_type() {
		return person_type;
	}

	public void setPerson_type(int person_type) {
		this.person_type = person_type;
	}

	@Override
	public String toString() {
		return "Person [idperson=" + idperson + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", address1=" + address1
				+ ", address2=" + address2 + ", post_number=" + post_number
				+ ", phone=" + phone + ", email=" + email + ", password="
				+ password + ", person_type=" + person_type + "]";
	}

	
}
