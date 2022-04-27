package com.springsecurity.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.springsecurity.dto.JobPostingDTO;
import com.springsecurity.dto.SignupDTO;

@Repository
public class JobPostingDAOImpl implements JobPostingDAO {

	@Override
	public void postJob(JobPostingDTO jobPostingDTO) {
		// TODO Auto-generated method stub

		Configuration con = new Configuration().configure().addAnnotatedClass(JobPostingDTO.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		System.out.println(jobPostingDTO + "code herw");

		session.persist(jobPostingDTO);
		tx.commit();

	}

}
