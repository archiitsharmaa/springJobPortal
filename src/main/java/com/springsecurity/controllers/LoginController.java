package com.springsecurity.controllers;

import java.security.Principal;
import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springsecurity.dao.UserDAO;
import com.springsecurity.dto.SignupDTO;
import com.springsecurity.services.UserService;

@Controller
public class LoginController {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserService userService;

	@Autowired
	private UserDAO userDAO;

	@GetMapping("/loginForm")
	public String login() {

		return "loginForm";
	}

	

	@PostMapping("/process-signup")
	public ModelAndView processSignup(@ModelAttribute("signupdto") @Valid SignupDTO signupDTO , BindingResult result) {

		
		ModelAndView modelAndView = new ModelAndView("loginForm");
		
		String encodedPassword = passwordEncoder.encode(signupDTO.getPassword());
		signupDTO.setPassword(encodedPassword);

		
		System.out.println(result.hasErrors());
		if(result.hasErrors()) {
			ModelAndView repopulateModelAndView = new ModelAndView("signupForm");
			System.out.println("Has Errors");
			return repopulateModelAndView;
		}else {
//			userDAO.saveUser(signupDTO);
			
			userService.signup(signupDTO);
			
			
			return modelAndView;
		}
		

	}

	@GetMapping("/welcome")
	public String helloWorld(Principal principal, Authentication auth, Model model) {

		String username = principal.getName();


		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
		System.out.println(authorities);

//		auth.get

		model.addAttribute("roles", authorities);
		model.addAttribute("username", username);

		return "home-page";
	}

}
