package com.springJobPortal.jobs;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//service layer
@Service
@Transactional
public class PostedJobsService {

	// reference the repitory to be worked
	@Autowired
	PostedJobsRepository repo;

	//saves the record
	public void save(PostedJobs jobs) {

		repo.save(jobs);
	}
	
	//gets the list of the project
	public List<PostedJobs> listAll() {
		return (List<PostedJobs>) repo.findAll();
	}
	
	//deletes the object
	public void delete(Long id) {
		repo.deleteById(id);
	}

	//updates the project
	public void updateJob(Long jobid, String jobName, String companyName, String description) {
		repo.updatePost(jobid,jobName,companyName,description);
	}
}
