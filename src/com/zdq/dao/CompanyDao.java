package com.zdq.dao;

import java.util.List;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.zdq.model.Company;

public interface CompanyDao {
	
	public void importUserToDB(List<Company> company);
	public Bool hasCompanyTable(String tableName);
	public void saveCompany(List<Company> company);
	public List<String> companyName();
	
	public List<Company> getCompanyUser(String companyName);
	public List<Company> getCompanuGroup(String companyName);	
}
