package com.zdq.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.zdq.dao.CompanyDao;
import com.zdq.dao.impl.CompanyDaoImp;
import com.zdq.model.Company;
import com.zdq.model.MapModel;

public class CompanyAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String companyName;
	private String password;
	private String username;
	private String phone;
	private String home;
	private String department;
	private String position;
	private String qq;
	private String email;
	private Integer age;
	private String company;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	CompanyDao daoImp = new CompanyDaoImp();
	private Map<String,Object> dataMap;
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

	public String getCompany() throws Exception{
		List<String> companyNames = daoImp.companyName();
		dataMap = new HashMap<String, Object>();
		dataMap.clear();
		if (companyNames != null) {
			dataMap.put("companys", companyNames);  
	        // 放入一个是否操作成功的标识  
	        dataMap.put("success", true);
			return SUCCESS;
		}else{
			dataMap.put("faile", true);
    		return SUCCESS;
		}  
	}
	
	public String getCompanyUser() throws Exception{
		//String msg = URLDecoder.decode(companyName, "UTF-8");
				//System.out.print("接受的参数"+companyName+msg);
		String msg=companyName;//request.getAttribute(companyName).toString();
		System.out.print("接受的参数"+companyName+"----"+msg);
		List<Company> companys = daoImp.getCompanyUser(companyName);
		dataMap = new HashMap<String, Object>();
		dataMap.clear();
		if (companys != null) {
			dataMap.put("contacts", companys);  
	        // 放入一个是否操作成功的标识  
	        dataMap.put("success", true);
			return SUCCESS;
		}else{
			dataMap.put("faile", true);
    		return SUCCESS;
		}
	}
	public String getCompanyGroup() throws Exception{
		
		Map<String, List<MapModel>> companys = daoImp.getCompanuGroup(companyName);
		dataMap = new HashMap<String, Object>();
		dataMap.clear();
		if (companys != null) {
			dataMap.put("department", companys);  
	        // 放入一个是否操作成功的标识  
	        dataMap.put("success", true);
			return SUCCESS;
		}else{
			dataMap.put("faile", true);
    		return SUCCESS;
		}
	}
	public String updateContact() throws Exception{
		Company tmpCompany = new Company();
//		CompanyId companyId = new CompanyId();
		tmpCompany.setUsername(username);
		tmpCompany.setPhone(phone);
		tmpCompany.setAge(age);
		tmpCompany.setEmail(email);
		tmpCompany.setQq(qq);
		tmpCompany.setDepartment(department);
		tmpCompany.setPosition(position);
		tmpCompany.setHome(home);
		tmpCompany.setCompany(company);
//		tmpCompany.set(companyId);
		boolean rec = daoImp.updateContact(tmpCompany);
		dataMap = new HashMap<String, Object>();
		dataMap.clear();
		if (rec) {
	        dataMap.put("state", "Success");
			return SUCCESS;
		}else{
			dataMap.put("state","faile");
    		return SUCCESS;
		}  
	}
	
	
	
}
