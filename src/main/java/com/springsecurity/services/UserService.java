package com.springsecurity.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springsecurity.dto.SignupDTO;
import com.springsecurity.repository.UserRespository;

@Service
public class UserService {
	
	@Autowired
	UserRespository userRepository;

	public void signup(SignupDTO signupDTO) {
		userRepository.save(signupDTO);
		
	}
}
