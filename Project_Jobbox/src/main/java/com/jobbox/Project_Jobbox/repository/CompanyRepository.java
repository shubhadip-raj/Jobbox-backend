package com.jobbox.Project_Jobbox.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jobbox.Project_Jobbox.entity.Company;
@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>{

	@Query("select c from Company c where c.companyName=?1")
	Optional<Company> findByName(String companyName);
	@Query("select c from Company c where c.companyName=?1")
	Company findCompanyByName(String companyName);

}
