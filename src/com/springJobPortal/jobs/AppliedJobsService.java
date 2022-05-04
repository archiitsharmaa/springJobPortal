package com.springJobPortal.jobs;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//service layer
@Service
@Transactional
public class AppliedJobsService {
	
	// reference the repitory to be worked
	@Autowired
	AppliedJobsRepository repo;
	
	//saves the record
	public void save(AppliedJobs appliedjobs) {
		
		repo.save(appliedjobs);
	}

}
