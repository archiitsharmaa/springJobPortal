package com.springsecurity.validations.username;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsernameValidator implements ConstraintValidator<NotExistingUsername, String> {
 
    @Autowired 
    private UsernameValidateService usernameValidateService;
    
    
    public UsernameValidator(UsernameValidateService usernameValidateService) {
        
        this.usernameValidateService = usernameValidateService;
    }
    public void initialize(NotExistingUsername notExistingUsername) {
    }
 
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
  System.out.println("Code is in isvalid");
      System.out.println(usernameValidateService);
        return username != null &&!usernameValidateService.isUsernameExist(username);
    }
}
