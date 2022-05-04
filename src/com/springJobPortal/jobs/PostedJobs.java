package com.springJobPortal.jobs;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//declares the class as an entity/table for the orm 
@Entity
//setting up the table name 
@Table(name = "postedjobs")
public class PostedJobs {

	@Id
	// genrating the values auto amticalically for the id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String employerUsername;
	private String jobName;
	private String companyName;
	private String description;
	private String employerEmail;

	// constructor
	public PostedJobs() {

	}

	// setter and getters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployerUsername() {
		return employerUsername;
	}

	public void setEmployerUsername(String employerUsername) {
		this.employerUsername = employerUsername;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmployerEmail() {
		return employerEmail;
	}

	public void setEmployerEmail(String employerEmail) {
		this.employerEmail = employerEmail;
	}

	public PostedJobs(Long id, String employerUsername, String jobName, String companyName, String description,
			String employerEmail) {
		this.id = id;
		this.employerUsername = employerUsername;
		this.jobName = jobName;
		this.companyName = companyName;
		this.description = description;
		this.employerEmail = employerEmail;
	}

}
