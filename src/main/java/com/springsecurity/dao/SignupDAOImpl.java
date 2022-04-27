package com.springsecurity.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springsecurity.dto.SignupDTO;


@Repository
public class SignupDAOImpl implements SignupDAO {
	
	@Autowired
	private JdbcTemplate JdbcTemplate;
	
	@Override
	public void saveUser(SignupDTO signupDTO) {
		
//		String sql = "insert into users values(?,?,?,?,?,?)";
//		String sql2 = "insert into authorities values(?,?)";
//		
//		JdbcTemplate.update(sql, 
//				signupDTO.getUsername(), signupDTO.getPassword(),
//				signupDTO.getName(), signupDTO.getEmail(),
//				signupDTO.getPhone(), 1);
//		
//		JdbcTemplate.update(sql2,signupDTO.getUsername(), 
//				signupDTO.getUserType());
		
		
		Configuration con = new Configuration().configure().addAnnotatedClass(SignupDTO.class);
		
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		
		System.out.println(signupDTO+ "code herw");
		
		session.persist(signupDTO);
		tx.commit();
		

	}

}
