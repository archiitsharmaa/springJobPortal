package com.springJobPortal.jobs;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.springJobPortal.model.PostedJobs;

//default jpa repository crud which has basic
public interface PostedJobsRepository extends CrudRepository<PostedJobs, Long> {

	// implements the function to get object by username
	@Query("SELECT jobs FROM PostedJobs jobs WHERE jobs.employerUsername = :username")
	public List<PostedJobs> getpostedjobs(@Param("username") String username);

	// implements the function to fetch applied jobs by a username
	@Query("Select jobs from PostedJobs jobs left join AppliedJobs appjob on jobs.id = appjob.jobid where appjob.candidateUsername = :username")
	public List<PostedJobs> getjobapplication(@Param("username") String username);

	// implements the fucntion to fetch the new jobs in the market
	@Query("select jobs from PostedJobs jobs where jobs.id not in (select appjob.jobid from AppliedJobs appjob where appjob.candidateUsername = :username)")
	public List<PostedJobs> marketplace(@Param("username") String username);

	// implements the funcitobn to updated the job
	@Modifying(clearAutomatically = true)
	@Query("update PostedJobs job set job.jobName=:jobName, job.companyName=:companyName, job.description=:description where job.id=:jobid")
	void updatePost(@Param("jobid") Long jobid, @Param("jobName") String jobName,
			@Param("companyName") String companyName, @Param("description") String description);

}
