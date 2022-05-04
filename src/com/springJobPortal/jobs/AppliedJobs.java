package com.springJobPortal.jobs;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import jakarta.persistence.Table;

//declares the class as an entity/table for the orm 
@Entity
//setting up the table name 
@Table(name = "appliedJobs")
public class AppliedJobs {

	@Id
	// genrating the values auto amticalically for the id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long jobid;
	private String candidateUsername;
	private String candidateEmail;

	// constructor
	public AppliedJobs() {
	}

	// constructor with feilds
	public AppliedJobs(Long id, Long jobid, String candidateUsername, String candidateEmail) {
		super();
		this.id = id;
		this.jobid = jobid;
		this.candidateUsername = candidateUsername;
		this.candidateEmail = candidateEmail;
	}

	// setter and getters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getJobid() {
		return jobid;
	}

	public void setJobid(Long jobid) {
		this.jobid = jobid;
	}

	public String getCandidateUsername() {
		return candidateUsername;
	}

	public void setCandidateUsername(String candidateUsername) {
		this.candidateUsername = candidateUsername;
	}

	public String getCandidateEmail() {
		return candidateEmail;
	}

	public void setCandidateEmail(String candidateEmail) {
		this.candidateEmail = candidateEmail;
	}

}
