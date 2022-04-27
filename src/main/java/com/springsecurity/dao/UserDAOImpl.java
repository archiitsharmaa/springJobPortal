package com.springsecurity.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springsecurity.dto.SignupDTO;
import com.springsecurity.validations.username.NotExistingUsername;

import jakarta.persistence.Column;
import jakarta.persistence.Id;


public class UserDAOImpl implements UserDAO {
	
	private String name;
	private String email;	
	private String phone;
	@Id
	@NotExistingUsername
	private String username;
	@Column(table = "authorities", name = "authority")
	private String userType;
	private String password;
	
	
		


}
