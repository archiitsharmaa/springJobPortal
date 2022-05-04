package com.springJobPortal.jobs;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

//default jpa repository crud which has basic
public interface AppliedJobsRepository extends CrudRepository<AppliedJobs, Long>{
	
	//implements the function to get object by id
	@Query(value = "Select b from AppliedJobs b where b.jobid = :keyword")		
	public List<AppliedJobs> displayCandidate(@Param("keyword") long keyword);

}
