package com.cerveceroscodigo.spring.dao;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="cust")
public class Customer {

	@Id
	@GeneratedValue
	@Column(name="idcust")
	private int idCustomer;
	
	@Size(min=2, max=50, message="Name must be between 5 and 50 characters")
	@Column(name="firstname")
	private String firstname;
	
	@Size(min=2, max=50, message="Name must be between 5 and 50 characters")
	@Column(name="lastname")
	private String lastname;
	
	@Size(min=2, max=50, message="Address must be between 5 and 50 characters")
	@Column(name="address1")
	private String address1;
	
	@Column(name="address2")
	private String address2;
	
	@Size(min=8, max=8, message="The phone number must be 8 digits long")
	@Column(name="phone")
	private String phone;
	
	@Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
	        +"(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", 
					message="This does not appear to be a valid email address")
	@Column(name="email")
	private String email;
	
	@Size(min=6, message="The password must be at least 5 characters long")
	@Column(name="password")
	private String password;
	
	@Valid
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="post_number")
	private Post post;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="idperson")
	private List<Orders> orders;
	
	
	public Customer(){
		
	}
	


	public Customer(int idCustomer, String firstname, String lastname,
			String address1, String address2, String phone, String email, String password,
			Post post, List<Orders> orders) {
		super();
		this.idCustomer = idCustomer;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address1 = address1;
		this.address2 = address2;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.post = post;
		this.orders = orders;
	}



	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
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

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "Customer [idCustomer=" + idCustomer + ", firstname="
				+ firstname + ", lastname=" + lastname + ", address1="
				+ address1 + ", address2=" + address2 + ", phone=" + phone
				+ ", email=" + email + ", password=" + password + ", post="
				+ post + ", orders=" + orders + "]";
	}





	
}
