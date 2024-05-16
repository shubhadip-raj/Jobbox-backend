package com.jobbox.Project_Jobbox.service;

import java.util.List;

import com.jobbox.Project_Jobbox.entity.Job;
import com.jobbox.Project_Jobbox.entity.User;

public interface JobService {

	Job postJob(Job job);

	List<Job> getAllJobs();

	List<Job> findJobs(String jobRole);

//	List<Job> getJobsByHrEmail(String userEmail);

	List<Job> getJobsByJobId(int jobId);

	List<Job> getJobsByHrEmailEachCompany(String userEmail);

	String getCompanyNameById(int jobId);



	int getHrIdbyJobId(int jobId);

	String getJobTitleByJobId(int jobId);

	Job getJobByJobId(int jobId);

}
