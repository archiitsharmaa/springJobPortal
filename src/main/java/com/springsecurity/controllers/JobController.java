package com.springsecurity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.springsecurity.dao.JobPostingDAO;
import com.springsecurity.dao.UserDAO;
import com.springsecurity.dto.JobPostingDTO;

@Controller
public class JobController {
	
	@Autowired
	private JobPostingDAO jobPostingDAO;
	
	
	@PostMapping("/process-jobposting")
	public String processJob(JobPostingDTO jobPostingDTO) {


		jobPostingDAO.postJob(jobPostingDTO);

		return "redirect:/loginForm";
	}

}
