package com.springJobPortal.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//service layer
@Service
@Transactional
public class CustomerService {

	// reference the repitory to be worked
	@Autowired
	CustomerRepository repo;

	// reference to the password
	@Autowired
	private PasswordEncoder passwordEncoder;

	// function to save the customer object to the table
	public void save(Customer customer) {

		// sets the normal password and replaces it with enctypted password
		String encodedPassword = passwordEncoder.encode(customer.getPassword());

		customer.setPassword(encodedPassword);

		// save
		repo.save(customer);
	}

	// list alll table
	public List<Customer> listAll() {
		return (List<Customer>) repo.findAll();
	}

	// gets the object by id
	public Customer get(Long id) {
		return repo.findById(id).get();
	}

	// delets the object by id
	public void delete(Long id) {
		repo.deleteById(id);
	}

}
