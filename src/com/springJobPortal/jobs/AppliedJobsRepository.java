package com.springJobPortal.jobs;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

//default jpa repository crud which has basic
public interface AppliedJobsRepository extends CrudRepository<AppliedJobs, Long>{
	
	//implements the function to get object by id
	@Query(value = "Select appjob from AppliedJobs appjob where appjob.jobid = :keyword")		
	public List<AppliedJobs> displayCandidate(@Param("keyword") long keyword);
	

	//implements the withdraw job feature
	@Modifying
	@Query("delete from AppliedJobs apply where apply.jobid=:id AND apply.candidateUsername=:username")
	public void deleteApp(@Param("username") String username, @Param("id") Long id);

}
