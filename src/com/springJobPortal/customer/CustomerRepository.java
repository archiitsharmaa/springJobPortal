package com.springJobPortal.customer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

//default jpa repository crud which has basic 
public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	//implements the function to get object by username
	 @Query("SELECT u FROM Customer u WHERE u.username = :username")
	    public Customer getUserByUsername(@Param("username") String username);
	
}
