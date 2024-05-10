package com.jobbox.Project_Jobbox.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jobbox.Project_Jobbox.entity.Job;
@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {

	@Query("select job from Job job where job.jobTitle=?1")
	List<Job> findjobs(String jobRole);
	
	

	@Query("select job.companyName from Job job where job.hrName=?1")
	String getCompamyName(String userName);

	@Query("select job from Job job where job.hrEmail=?1 ")
	List<Job> getJobsByHrEmail(String userEmail);


	@Query("select job from Job job where job.jobId=?1")
	List<Job> getJobByJobId(int jobId);


	@Query("select job from Job job where job.companyName=?1")
	List<Job> getJobByheEmailCompany(String company);


	@Query("select job.companyName from Job job where job.jobId=?1")
	String getCompamyName(int jobId);


	@Query("select job.hrId from Job job where job.jobId=?1")
	int getHrIdbyJobId(int jobId);


	
	@Query("select job.jobTitle from Job job where job.jobId=?1")
	String getJobTitleByJobId(int jobId);

}
