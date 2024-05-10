package com.jobbox.Project_Jobbox.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobbox.Project_Jobbox.entity.Company;
import com.jobbox.Project_Jobbox.repository.CompanyRepository;
import com.jobbox.Project_Jobbox.service.CompanyService;
@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	public CompanyRepository repository;

	@Override
	public String saveCompany(Company c) {
		Optional<Company> com=repository.findByName(c.getCompanyName());
		if(com.isPresent())
		{
			return null;
		}
		else
		{
		repository.save(c);
		
		return "company saved";
		}
		
	}

	@Override
	public Company findCompanyById(int id) {
		
		Optional<Company> optional = repository.findById(id);
		if(optional.isPresent())
		{
			Company c=optional.get();
			return c;
		}
		
		return null;
	}

	@Override
	public Company findCompanyByName(String companyName) {
		
		return repository.findCompanyByName(companyName);
	}

	

	@Override
	public List<Company> getCompanies() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void updateCompany(Company c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUserStatus(String companyName, String actionDate, String companyStatus) {
		Company com =repository.findCompanyByName(companyName);
		com.setActionDate(actionDate);
		com.setCompanyStatus(companyStatus);
		
		repository.save(com);
		
	}

	@Override
	public void updateCompanyDetails(String companyName, String location1, String description) {
		
		Company company=repository.findCompanyByName(companyName);
		company.setLocation(location1);
		company.setDiscription(description);
		repository.save(company);
	}

}
