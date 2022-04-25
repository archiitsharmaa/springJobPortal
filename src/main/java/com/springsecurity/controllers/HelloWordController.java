package com.springsecurity.controllers;

import java.security.Principal;
import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWordController {

	@RequestMapping("/")
	public String defaultRedirect() {
		
		return "redirect:/signupForm";

	}

	@GetMapping("/employer")
	public String showEmployerDashboard() {

		return "employer-dashboard";

	}

	@GetMapping("/candidate")
	public String showCandidateDashboard() {

		return "candidate-dashboard";

	}

}
