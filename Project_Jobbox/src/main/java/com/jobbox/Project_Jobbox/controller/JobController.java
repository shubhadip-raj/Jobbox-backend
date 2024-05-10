package com.jobbox.Project_Jobbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jobbox.Project_Jobbox.entity.Job;
import com.jobbox.Project_Jobbox.service.JobService;
@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("/api/jobbox")
public class JobController {
	@Autowired
	public JobService jobService;
	
	@PostMapping("/postingJob")
	public ResponseEntity<Job> postJob(@RequestBody Job job)
	{	
		return new ResponseEntity<Job>(jobService.postJob(job), HttpStatus.CREATED);
	}
	
	
	@GetMapping("/displayJobs")
	public ResponseEntity<List<Job>> showJob()	{
		List<Job> jobs=jobService.getAllJobs();
		return new ResponseEntity<List<Job>>(jobs, HttpStatus.OK);
	}
	
	
	@GetMapping("/search/{jobRole}")
	public ResponseEntity<List<Job>> searchJobs(@PathVariable("jobRole") String jobRole)
	{
		List<Job> jobs=jobService.findJobs(jobRole);
		return new ResponseEntity<List<Job>>(jobs, HttpStatus.FOUND);
		
	}
	
	@GetMapping("/jobsPostedByHrEmail")
	public ResponseEntity<List<Job>> showJobbyHrEmail(@RequestParam String userEmail)	{
		List<Job> jobs=jobService.getJobsByHrEmail(userEmail);
		System.out.println(userEmail);
		for(Job job:jobs)
		{
			System.out.println(job.toString());
		}
		return new ResponseEntity<List<Job>>(jobs, HttpStatus.OK);	
	}
	
	@GetMapping("/jobsPostedByHrEmaileachCompany")
	public ResponseEntity<List<Job>> getJobbyHrEmailEchCompany(@RequestParam String userEmail)	{
		List<Job> jobs=jobService.getJobsByHrEmailEachCompany(userEmail);
		System.out.println(userEmail);
		for(Job job:jobs)
		{
			System.out.println(job.toString());
		}
		return new ResponseEntity<List<Job>>(jobs, HttpStatus.OK);		
	}
	
	
	@GetMapping("/getJobsByjobId")
	public ResponseEntity<List<Job>> showJobbyJobId(@RequestParam int jobId)	{
		List<Job> jobs=jobService.getJobsByJobId(jobId);
		System.out.println(jobId);
		for(Job job:jobs)
		{
			System.out.println(job.toString());
		}
		return new ResponseEntity<List<Job>>(jobs, HttpStatus.OK);
	}
	
	
	@GetMapping("/getJob")
	public ResponseEntity<Job> getJob(@RequestParam int jobId)
	{
		return new ResponseEntity<Job>(jobService.getJobByJobId(jobId), HttpStatus.OK);
	}


}
