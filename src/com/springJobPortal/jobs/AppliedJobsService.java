package com.springJobPortal.jobs;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springJobPortal.model.AppliedJobs;

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
	
	//deletes the object
		public void delete(Long id) {
			repo.deleteById(id);
		}

		public void deleteApplication(String username, Long id) {
			
			repo.deleteApp(username,id);
			
		}

}
