package com.cerveceroscodigo.spring.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;


/**
 * Denne klassen er java-versjonen av dataene som ligger i mysql.
 * @Id representerer kolonnenen som er primærnøkkel i databasen.
 * @Column spesifiserer kolonnenavnet
 * Viktig å bruke vanlig Java-standard på variabelnavn, og Eclipse til å generere get/set-metoder.
 * MÅ ha default konstruktør  
 *
 */

@Entity
@Table(name="post")
public class Post {

	@Size(min=4, max=6, message="Post code must be between 4 and 6 characters")
	@Id
	@Column(name="post_number")
	private String postNumber;
	
	@Size(min=2, max=45, message="Post address must be between 2 and 45 characters")
	@Column(name="post_address")
	private String postAddress;

	public Post(){
		
	}
	

	public String getPostNumber() {
		return postNumber;
	}



	public void setPostNumber(String postNumber) {
		this.postNumber = postNumber;
	}



	public String getPostAddress() {
		return postAddress;
	}



	public void setPostAddress(String postAddress) {
		this.postAddress = postAddress;
	}



	public Post(String post_number, String post_address) {
		super();
		this.postNumber = post_number;
		this.postAddress = post_address;
	}


	@Override
	public String toString() {
		return "Post [post_number=" + postNumber + ", post_address="
				+ postAddress + "]";
	}

}
