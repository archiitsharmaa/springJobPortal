package com.springsecurity.validations.username;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.springframework.stereotype.Service;

import com.springsecurity.dto.SignupDTO;
@org.springframework.context.annotation.Configuration
@Service
public class UsernameValidateService {
 
    public boolean isUsernameExist(String username) {
        
        SignupDTO user = null;
        System.out.println("code here");
        Configuration con = new Configuration().configure().addAnnotatedClass(SignupDTO.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        user = session.get(SignupDTO.class, username);
    
        System.out.println(user);
        tx.commit();
        
        sf.close();
        session.close();
        
        if(user != null) {
            return true;
        }else {
            return false;
        }
    
        
    }
}
