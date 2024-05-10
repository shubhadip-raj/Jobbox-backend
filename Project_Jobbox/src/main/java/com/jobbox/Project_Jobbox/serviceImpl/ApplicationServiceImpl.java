package com.jobbox.Project_Jobbox.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobbox.Project_Jobbox.entity.Application;
import com.jobbox.Project_Jobbox.repository.ApplicationRepository;
import com.jobbox.Project_Jobbox.service.ApplicationService;

@Service
public class ApplicationServiceImpl implements ApplicationService{
	
	@Autowired
	public ApplicationRepository applicationRepository;

	@Override
	public Application applyJob(Application app) {
		// TODO Auto-generated method stub
		return applicationRepository.save(app);
	}

	@Override
	public List<Application> getApplicationsByCandidateId(int candidateId) {
		
		return applicationRepository.getApplicationsByCandidateId(candidateId);
	}

	@Override
	public List<Application> getApplicationsByHRId(int hrId) {
		
		return applicationRepository.getApplicationsByHRId(hrId);
	}

	@Override
	public Application updateApplicationStatus(int applicationId, String newStatus) {
		Application app=applicationRepository.getById(applicationId);
		app.setApplicationStatus(newStatus);
		app=applicationRepository.save(app);
		return app;
	}

	@Override
	public Application getApplication(int applicationId) {
		// TODO Auto-generated method stub
		return applicationRepository.getById(applicationId);
	}

	@Override
	public List<Application> getApplicationsByJobId(int jobId) {
		
		return applicationRepository.getApplicationsByJobId(jobId);
	}

}
