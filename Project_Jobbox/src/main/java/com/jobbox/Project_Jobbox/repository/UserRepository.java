package com.jobbox.Project_Jobbox.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jobbox.Project_Jobbox.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	
	@Query("select u from User u where u.userRole=?1")
	List<User> findHr(String userRole);

	@Query("UPDATE User u SET u.userStatus = ?3, u.approvedOn = ?2 WHERE u.userEmail = ?1"  )
	void updateUserStatus(String userEmail, String approvedOn,String userStatus);
	
	
	
	@Query("select u from User u where u.userEmail=?1")
	User findUserByEmail(String userEmail);
	
	@Query("select u from User u where u.userEmail=?1")
	User getHrNameByEmail(String userEmail);

	@Query("select u from User u where u.userEmail=?1")
	User getHrByEmail(String userEmail);

	@Query("select u.companyName from User u where u.userEmail=?1")
	String getCompanyByEmail(String email);
	@Query("select u.userId from User u where u.userEmail=?1")
	Integer getUserIdByEmail(String userEmail);
	@Query("select u.userName from User u where u.userEmail=?1")
	String findHrNameByEmail(String email);
	
	@Query("select u from User u where u.companyName=?1")
	List<User> findHrBycomapnyName(String companyName);
	@Query("select u.companyName from User u where u.userId=?1")
	String getCompanyById(int id);

	
	@Query("select u from User u where u.userEmail=?1")
	public User findByUserName(String userEmail);
//	@Query("select u.password from User u where u.userEmail=?1")
//	String findUserPasswordByName(String email);
//
//	@Query("select u from User u where u.userRole=?1")
//	List<User> findUser(String userRole);
//	
//	@Query("select u.userRole from User u where u.userEmail=?1")
//	String findUserRole(String email);
//
//	Optional<User> findByEmail(String userEmail);
	
	

}
