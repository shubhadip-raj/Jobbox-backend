package com.jobbox.Project_Jobbox.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobbox.Project_Jobbox.entity.Company;
import com.jobbox.Project_Jobbox.entity.Job;
import com.jobbox.Project_Jobbox.entity.User;
import com.jobbox.Project_Jobbox.repository.CompanyRepository;
import com.jobbox.Project_Jobbox.repository.JobRepository;
import com.jobbox.Project_Jobbox.repository.UserRepository;
import com.jobbox.Project_Jobbox.service.JobService;
@Service
public class JobServiceImpl implements JobService {
	@Autowired
	public JobRepository repository;
	@Autowired
	public UserRepository userRepository;

//	@Autowired
//	public CompanyRepository companyRepository;
//	
	@Override
	public Job postJob(Job job) {
		String email=job.getUserEmail();
		User user = userRepository.findUserByEmail(email);
		//Company company = companyRepository.findCompanyByName(email);
		job.setUserId(user.getUserId());;
		job.setUserEmail(user.getUserEmail());
		job.setUserName(user.getUserName());
//		String hrEmail = user.getUserEmail();
//		String[] emailParts = hrEmail.split("@");
//		String domain = emailParts[1];
//	    String[] domainParts = domain.split("\\.");
//	    String companyName = domainParts[0];
		job.setCompanyName(user.getCompanyName());
		return repository.save(job);
	
	}

//	 public List<Job> getJobsByHrEmailAndCompanyName(String userEmail, String companyName) {
//	        return repository.findByHrEmailAndCompanyName(userEmail, companyName);
//	    }


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
	
//	
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
//		return repository.getCompamyName(jobId);
		return null;
	}


	@Override
	public int getHrIdbyJobId(int jobId) {
		// TODO Auto-generated method stub
//		return repository.getHrIdbyJobId(jobId);
		return 0;
	}

	@Override
	public String getJobTitleByJobId(int jobId) {
		
		return repository.getJobTitleByJobId(jobId) ;
	}


	@Override
	public Job getJobByJobId(int jobId) {
		
		return repository.getById(jobId);
	}
	public boolean updateJob(Job job) {
		try {
			repository.save(job);
			return true;
		}
		catch (Exception e) {
			// TODO: handle exception  
			e.printStackTrace();
            return false;
		}
	}
	
}
