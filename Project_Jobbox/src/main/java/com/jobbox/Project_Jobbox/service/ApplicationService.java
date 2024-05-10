package com.jobbox.Project_Jobbox.service;

import java.util.List;

import com.jobbox.Project_Jobbox.entity.Application;

public interface ApplicationService {

	Application applyJob(Application app);

	List<Application> getApplicationsByCandidateId(int candidateId);

	List<Application> getApplicationsByHRId(int hrId);

	Application updateApplicationStatus(int applicationId, String newStatus);

	Application getApplication(int applicationId);

	List<Application> getApplicationsByJobId(int jobId);

}
