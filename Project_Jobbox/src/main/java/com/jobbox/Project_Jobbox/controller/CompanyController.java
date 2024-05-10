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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jobbox.Project_Jobbox.entity.Company;
import com.jobbox.Project_Jobbox.service.CompanyService;
@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("/api/jobbox")
public class CompanyController{
	
	@Autowired
	public CompanyService service;
	
	
	@PostMapping("/saveCompany")
	public ResponseEntity<String> saveCompany(@RequestBody Company c)
	
	{
		String companyName=c.getCompanyName();
		String jobboxEmail=companyName.toLowerCase()+"@jobbox.com";
		c.setJobboxEmail(jobboxEmail);
		String s=service.saveCompany(c);
	if(s==null)
	{
		return new ResponseEntity<String>("company already present", HttpStatus.NOT_ACCEPTABLE);
	}
	else
		return new ResponseEntity<String>("company save succesfully", HttpStatus.CREATED);
		
	}
//	
////	@GetMapping("/")
////	public ModelAndView getoutput()
////	{
////		return new ModelAndView("output");
////	}
//	
//	@GetMapping("/findbyid/{id}")
//	public String findCompanyById(@PathVariable int id)
//	{
//		Company c=service.findCompanyById(id);
//		return c.toString();
//	}
//	
	@GetMapping("/displayCompanies")
	public ResponseEntity<List<Company>> displayCompany()
	{
		
		List<Company> compnies=service.getCompanies();
		
		
		
		return new ResponseEntity<List<Company>>(compnies, HttpStatus.OK);
		
	}
//	
	@PutMapping("/updateApproveCompany")
	public ResponseEntity<String> updateUser(@RequestParam  String companyName, @RequestParam String actionDate, @RequestParam String companyStatus)
	{
		
		service.updateUserStatus(companyName,actionDate,companyStatus);
		return new ResponseEntity<String>("update successFull", HttpStatus.OK);
		
	}
	
	
	@PutMapping("/updateCompanyByName")
	public ResponseEntity<String> updateCompanyDetails(@RequestParam  String companyName, @RequestParam String location1, @RequestParam String description)
	{
		
		service.updateCompanyDetails(companyName,location1,description);
		return new ResponseEntity<String>("update successFull", HttpStatus.OK);
		
	}

//	
//	
//	
//
}














