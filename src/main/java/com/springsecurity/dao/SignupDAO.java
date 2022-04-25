package com.springsecurity.dao;

import com.springsecurity.dto.SignupDTO;

public interface SignupDAO {
	
	void saveUser(SignupDTO signupDTO);

}
