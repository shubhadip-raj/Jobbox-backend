package com.jobbox.Project_Jobbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jobbox.Project_Jobbox.entity.User;
import com.jobbox.Project_Jobbox.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("/api/jobbox")

public class UserController {
	
	@Autowired
	public UserService  service;

	
	
	
	
	
	@PostMapping("/saveUser")
	public ResponseEntity<User> saveUser(@RequestBody User u)
	
	{ 
		 
		User user=service.saveUser(u);
		return new ResponseEntity<User>(user, HttpStatus.OK);
			
	}
	
	
	@GetMapping("/login")
	public ResponseEntity<User> userLogin(@RequestParam String userEmail, @RequestParam String password)
	{
		User user=service.getUserByEmail(userEmail,password);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	

	@GetMapping("/displayUsers")
	public ResponseEntity<List<User>> getUserPage() {
		List<User> usersList = null;
		try {
			usersList = service.getUserList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return new ResponseEntity<List<User>>(usersList,HttpStatus.OK);
	}
	
	@GetMapping("/getHr")
	public ResponseEntity<List<User>>  getHRPage() {
		List<User> usersList = null;
		try {
			usersList = service.getHRList("HR");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return new ResponseEntity<List<User>>(usersList, HttpStatus.OK);
	}
	


	@PutMapping("/updateApprove")
	public ResponseEntity<String> updateUser(@RequestParam  String userEmail, @RequestParam String approvedOn,@RequestParam String userStatus)
	{
		
		service.updateUserStatus(userEmail,approvedOn,userStatus);
		return new ResponseEntity<String>("update successFull", HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deleteUser")
	public ResponseEntity<String> deleteUser(@RequestParam  String userEmail)
	{
		
		service.deleteUser(userEmail);
		return new ResponseEntity<String>("update successFull", HttpStatus.OK);
		
	}
	
	@GetMapping("/getHRName")
	public ResponseEntity<User> getHrNameByEmail(@RequestParam String userEmail)
	{
		User u=service.getHrNameByEmail(userEmail);
		System.out.println(u.getUserName());
		
		return new ResponseEntity<User>(u,HttpStatus.OK);
		
	}
	
	@GetMapping("/getHrByEmail")
	public ResponseEntity<User> getHrByEmail(@RequestParam String userEmail)
	{
		User u=service.getHrByEmail(userEmail);
		
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}
	
	@GetMapping("/getCandidate")
	public ResponseEntity<User> getCandidateEmail(@RequestParam String userEmail)
	{
		User u=service.getHrByEmail(userEmail);
		
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}
	
	@GetMapping("/getHrEachCompany")
	public ResponseEntity<List<User>>  getHR(@RequestParam String userEmail) {
		List<User> usersList = null;
		try {
			usersList = service.getHRListEachCompany(userEmail);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return new ResponseEntity<List<User>>(usersList, HttpStatus.OK);
	}

	
	@GetMapping("/getUser")
	public ResponseEntity<User> getUser(@RequestParam int userId)
	{
		return new ResponseEntity<User>(service.getUser(userId), HttpStatus.OK);
	}
	
}

   

























