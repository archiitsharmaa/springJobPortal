package com.springsecurity.controllers;

import java.security.Principal;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springsecurity.dao.SignupDAO;
import com.springsecurity.dto.SignupDTO;

@Controller
public class LoginController {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private SignupDAO signupDAO;

	@GetMapping("/loginForm")
	public String login() {

		return "loginForm";
	}

	@GetMapping("/signupForm")
	public String signupForm(@ModelAttribute("signupdto") SignupDTO signupDTO) {

		return "signupForm";
	}

	@PostMapping("/process-signup")
	public String processSignup(SignupDTO signupDTO) {

		String encodedPassword = passwordEncoder.encode(signupDTO.getPassword());
		signupDTO.setPassword(encodedPassword);

		// SAVE THE DTO : dto call

		signupDAO.saveUser(signupDTO);

		return "redirect:/loginForm";
	}

	@GetMapping("/welcome")
	public String helloWorld(Principal principal, Authentication auth, Model model) {

		String username = principal.getName();

		System.out.println(username);

		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
		System.out.println(authorities);

//		auth.get

		model.addAttribute("roles", authorities);
		model.addAttribute("username", username);

		return "home-page";
	}

}
