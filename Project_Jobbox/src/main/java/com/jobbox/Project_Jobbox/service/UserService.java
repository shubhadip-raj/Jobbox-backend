package com.jobbox.Project_Jobbox.service;

import java.util.List;



import com.jobbox.Project_Jobbox.entity.User;

public interface UserService {

	User saveUser(User u);

	List<User> getHRList(String string);

	
	void updateUserStatus(String userEmail, String approvedOn, String userStatus);

	void deleteUser(String userEmail);

	List<User> getUserList();

	User getHrNameByEmail(String userEmail);

	User getHrByEmail(String userEmail);

	List<User> getHRListEachCompany(String userEmail);

	User getUserByEmail(String userEmail, String password);

	int getuserIdByEmail(String userEmail);

	String getCompanyNameById(int id);

	User getUser(int userId);

	

//	String findUserPasswordByName(String email);
//

//
//	List<User> getHRList(String userRole);
//
//	String findUserRole(String email);
//
//	User loginUser(String userEmail, String password);
}
