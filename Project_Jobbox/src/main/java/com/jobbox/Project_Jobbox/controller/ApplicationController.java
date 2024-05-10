package com.jobbox.Project_Jobbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jobbox.Project_Jobbox.entity.Application;
import com.jobbox.Project_Jobbox.service.ApplicationService;
import com.jobbox.Project_Jobbox.service.JobService;
import com.jobbox.Project_Jobbox.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("/api/jobbox")
public class ApplicationController {
	
	@Autowired
	public ApplicationService applicationService;
	
	@Autowired
	public UserService userService;
	

	@Autowired
	public JobService jobService;

	
	
	
	
	
	@PutMapping("/applyJob")
	public ResponseEntity<Application> applyJob(@RequestParam int jobId, @RequestParam String userEmail,@RequestParam String appliedOn)
	{
		System.out.println(jobId+ userEmail);
		Application app=new Application();
		app.setJobId(jobId);
		app.setCompanyName(jobService.getCompanyNameById(jobId));
		app.setCandidateId(userService.getuserIdByEmail(userEmail));
		app.setJobRole(jobService.getJobTitleByJobId(jobId));
		app.setHrId(jobService.getHrIdbyJobId(jobId));
		app.setAppliedOn(appliedOn);
		app.setApplicationStatus("Under Preview");
		
		app=applicationService.applyJob(app);
		return new ResponseEntity<Application>(app, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/applications")
	public ResponseEntity<List<Application>> application(@RequestParam String userEmail)
	{
		int candidateId=userService.getuserIdByEmail(userEmail);
		List<Application> applications=applicationService.getApplicationsByCandidateId(candidateId);
		return new ResponseEntity<List<Application>>(applications, HttpStatus.OK);
		
	}
	
	@GetMapping("/getApplicationsByHR")
	public ResponseEntity<List<Application>> getApplicationsForEachHR(@RequestParam String userEmail)
	{
		int hrId=userService.getuserIdByEmail(userEmail);
		List<Application> applications=applicationService.getApplicationsByHRId(hrId);
		return new ResponseEntity<List<Application>>(applications, HttpStatus.OK);
		
	}
	
	@PutMapping("/updateApplicationStatus")
	public ResponseEntity<Application> updateApplicatioStatus(@RequestParam int applicationId, @RequestParam String newStatus)
	{
		Application app=applicationService.updateApplicationStatus(applicationId,newStatus);
		return new ResponseEntity<Application>(app, HttpStatus.OK);
	}
	
	@GetMapping("/getApplication")
	public ResponseEntity<Application> getApplication(@RequestParam int applicationId)
	{
		Application app=applicationService.getApplication(applicationId);
		return new ResponseEntity<Application>(app, HttpStatus.OK);
		
	}
	
	@GetMapping("/getApplicationsByJobId")
	public ResponseEntity<List<Application>> getApplicationsByJobId(@RequestParam int jobId)
	{
		
		List<Application> applications=applicationService.getApplicationsByJobId(jobId);
		return new ResponseEntity<List<Application>>(applications, HttpStatus.OK);
		
	}




	
	

}
