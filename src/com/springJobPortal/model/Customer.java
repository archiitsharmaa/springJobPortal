package com.springJobPortal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import jakarta.persistence.Table;

//declares the class as an entity/table for the orm 
@Entity
//setting up the table name 
@Table(name = "customer")
public class Customer {
	@Id
	// genrating the values auto amticalically for the id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String email;
	private String username;
	private String Phone;
	private String password;
	private String role;

	// constructor
	public Customer() {
	}

	// constructor with feilds
	protected Customer(String name, String email, String username, String Phone, String password, String role) {
		this.name = name;
		this.email = email;
		this.username = username;
		this.Phone = Phone;
		this.password = password;
		this.role = role;
	}

	// setter and getters
	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
