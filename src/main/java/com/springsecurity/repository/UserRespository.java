package com.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springsecurity.dto.SignupDTO;

public interface UserRespository extends JpaRepository<SignupDTO, String>{
	
	
	
}
