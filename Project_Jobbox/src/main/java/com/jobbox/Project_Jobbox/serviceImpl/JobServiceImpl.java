package com.jobbox.Project_Jobbox.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobbox.Project_Jobbox.entity.Job;
import com.jobbox.Project_Jobbox.repository.JobRepository;
import com.jobbox.Project_Jobbox.repository.UserRepository;
import com.jobbox.Project_Jobbox.service.JobService;
@Service
public class JobServiceImpl implements JobService {
	@Autowired
	public JobRepository repository;
	@Autowired
	public UserRepository userRepository;

	@Override
	public Job postJob(Job job) {
		String email=job.getHrEmail();
		String company=userRepository.getCompanyByEmail(email);
		int hrId=userRepository.getUserIdByEmail(email);
	String hrName=userRepository.findHrNameByEmail(email);
		job.setCompanyName(company);
		job.setHrId(hrId);
		job.setHrName(hrName);
		return repository.save(job);
		
	}

	@Override
	public List<Job> getAllJobs() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

//	@Override
//	public Job findJobs(String jobRole) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public List<Job> findJobs(String jobRole) {
		// TODO Auto-generated method stub
//		return repository.findjobs(jobRole);
		return repository.findjobs(jobRole);
	}

	@Override
	public List<Job> getJobsByHrEmail(String userEmail) {
		//String companyName=repository.getCompamyName(userEmail);
		
		return repository.getJobsByHrEmail(userEmail);
	}

	@Override
	public List<Job> getJobsByJobId(int jobId) {
		// TODO Auto-generated method stub
		return repository.getJobByJobId(jobId);
	}

	@Override
	public List<Job> getJobsByHrEmailEachCompany(String userEmail) {
		String company=userRepository.getCompanyByEmail(userEmail);
		
		return repository.getJobByheEmailCompany(company);
	}

	@Override
	public String getCompanyNameById(int jobId) {
		// TODO Auto-generated method stub
		return repository.getCompamyName(jobId);
	}


	@Override
	public int getHrIdbyJobId(int jobId) {
		// TODO Auto-generated method stub
		return repository.getHrIdbyJobId(jobId);
	}

	@Override
	public String getJobTitleByJobId(int jobId) {
		
		return repository.getJobTitleByJobId(jobId) ;
	}

	@Override
	public Job getJobByJobId(int jobId) {
		
		return repository.getById(jobId);
	}

}
