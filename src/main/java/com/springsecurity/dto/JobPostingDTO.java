package com.springsecurity.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PostedJobs")
public class JobPostingDTO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String EmployeeUsername;
	private String JobName;
	private String CompanyName;
	private String Description;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmployeeUsername() {
		return EmployeeUsername;
	}
	public void setEmployeeUsername(String employeeUsername) {
		EmployeeUsername = employeeUsername;
	}
	public String getJobName() {
		return JobName;
	}
	public void setJobName(String jobName) {
		JobName = jobName;
	}
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	
	

}
