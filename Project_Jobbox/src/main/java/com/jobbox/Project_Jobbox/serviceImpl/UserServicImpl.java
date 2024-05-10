package com.jobbox.Project_Jobbox.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jobbox.Project_Jobbox.entity.User;
import com.jobbox.Project_Jobbox.repository.UserRepository;
import com.jobbox.Project_Jobbox.service.UserService;

@Service

public class UserServicImpl implements UserService{
	
	@Autowired
	public UserRepository repository;
	@Autowired
	public BCryptPasswordEncoder bCryptPasswordEncoder;


	@Override
	public User saveUser(User user) {
		 String plainTextPassword = user.getPassword(); // Get the plain text password
////
////	        // Hash the password using BCryptPasswordEncoder
	        String hashedPassword =bCryptPasswordEncoder.encode(plainTextPassword);
//
//	        // Set the hashed password back to the user object
	        	user.setPassword(hashedPassword);
//
//	        // Save the user with the hashed password
	        return repository.save(user);
	
	}


//	@Override
//	public String findUserPasswordByName(String email) {
//	return repository.findUserPasswordByName(email);
//		
//		
//	}
//
//	@Override
//	public List<User> getUserList(String hr) {
//		
//		return repository.findAll();
//	}
//
	@Override
	public List<User> getHRList(String userRole) {
	return repository.findHr(userRole);
		
		
	}


	@Override
	public void updateUserStatus(String userEmail, String approvedOn,String userStatus) {
		User u=repository.findUserByEmail(userEmail);
		u.setApprovedOn(approvedOn);
		u.setUserStatus(userStatus);
		repository.save(u);
		
	}


	@Override
	public void deleteUser(String userEmail) {
		
		// TODO Auto-generated method stub
		User u=repository.findUserByEmail(userEmail);
		repository.delete(u);
	}


	@Override
	public List<User> getUserList() {
		List<User> users=repository.findAll();
		return users;
	}


	@Override
	public User getHrNameByEmail(String userEmail) {
		
		User u=repository.getHrNameByEmail(userEmail);
		return u;
		
		
	}


	@Override
	public User getHrByEmail(String userEmail) {
		
		return repository.getHrByEmail(userEmail);
	}


	@Override
	public List<User> getHRListEachCompany(String userEmail) {
		String companyName=repository.findUserByEmail(userEmail).getCompanyName();
		return repository.findHrBycomapnyName(companyName);
	}


	@Override
	public User getUserByEmail(String userEmail,String password) {
	User user=repository.findUserByEmail(userEmail);
	String exixtPassword=user.getPassword();
	System.out.println(exixtPassword);
	// String hashedPassword =bCryptPasswordEncoder.encode(exixtPassword);
	 
	 boolean isValid=bCryptPasswordEncoder.matches( password,exixtPassword);
	 if(isValid)
		 return user;
	
	 else
		return null;
	}


	@Override
	public int getuserIdByEmail(String userEmail) {
	
		return repository.getUserIdByEmail(userEmail);
	}


	@Override
	public String getCompanyNameById(int id) {
		// TODO Auto-generated method stub
		return repository.getCompanyById(id);
	}


	@Override
	public User getUser(int userId) {
		// TODO Auto-generated method stub
		return repository.getById(userId);
	}
	}
//
//	@Override
//	public String findUserRole(String email) {
//		
//	return repository.findUserRole(email);
//		
//	}
//
//	@Override
//	public User loginUser(String userEmail, String password) {
//////		 Optional<User> user = repository.findByEmail(userEmail);
//////		 if(user.isPresent())
//////		 {
//////			 User u=user.get();
//////			 if(!u.getPassword().equals(password))
//////				 return null;
//////			 else 
//////				 return u;
//////		 }
////		
//		return null;
//	}
//
//}
