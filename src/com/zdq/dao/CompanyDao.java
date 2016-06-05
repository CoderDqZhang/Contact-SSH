package com.zdq.dao;

import java.util.List;
import java.util.Map;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.zdq.model.Company;
import com.zdq.model.MapModel;

public interface CompanyDao {
	
	public void importUserToDB(List<Company> company);
	public Bool hasCompanyTable(String tableName);
	public void saveCompany(List<Company> company);
	public List<String> companyName();
	
	public boolean updateContact(Company company);
	
	public List<Company> getCompanyUser(String companyName);
	public Map<String,List<MapModel>> getCompanuGroup(String companyName);	
}
