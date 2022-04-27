package com.springsecurity.dto;

public class JobAppliedDTO {
	
	private int id;
	public String CandidateName;
	public String CandidateEmail;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCandidateName() {
		return CandidateName;
	}
	public void setCandidateName(String candidateName) {
		CandidateName = candidateName;
	}
	public String getCandidateEmail() {
		return CandidateEmail;
	}
	public void setCandidateEmail(String candidateEmail) {
		CandidateEmail = candidateEmail;
	}
	
	

}
