package com.springJobPortal.jobs;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

//default jpa repository crud which has basic
public interface PostedJobsRepository extends CrudRepository<PostedJobs, Long>{

	//implements the function to get object by username
	@Query("SELECT u FROM PostedJobs u WHERE u.employerUsername = :username")
    public List<PostedJobs> getpostedjobs(@Param("username") String username);


}
