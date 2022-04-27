package com.springsecurity.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.springsecurity.dto.JobPostingDTO;
import com.springsecurity.dto.SignupDTO;

@Controller
public class HelloWordController {

	@GetMapping("/")
	public String signupForm(@ModelAttribute("signupdto") SignupDTO signupDTO) {

		return "signupForm";
	}

	@GetMapping("/employer")
	public String showEmployerDashboard(@ModelAttribute("jobPostingDTO") JobPostingDTO jobPostingDTO) {

		return "employer-dashboard";

	}

	@GetMapping("/candidate")
	public String showCandidateDashboard() {

		return "candidate-dashboard";

	}

}
