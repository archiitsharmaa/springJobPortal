package com.springsecurity.dto;

import org.hibernate.annotations.ColumnDefault;

import com.springsecurity.validations.username.NotExistingUsername;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "users")
@SecondaryTable(name = "authorities")
public class SignupDTO {
	
	
	private String name;
	private String email;	
	private String phone;
	@Id
	@NotExistingUsername
	private String username;
	@Column(table = "authorities", name = "authority")
	private String userType;
	private String password;
	
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "SignupDTO [name=" + name + ", email=" + email + ", phone=" + phone + ", username=" + username
				+ ", userType=" + userType + ", password=" + password + "]";
	}
	
	
	
	

}
