package com.jobbox.Project_Jobbox.service;

import java.util.List;

import com.jobbox.Project_Jobbox.entity.Company;

public interface CompanyService {

	String saveCompany(Company c);

	Company findCompanyById(int id);

	Company findCompanyByName(String companyName);

	void updateCompany(Company c);

	List<Company> getCompanies();

	void updateUserStatus(String companyName, String actionDate, String companyStatus);

	void updateCompanyDetails(String companyName, String location1, String description);

}
