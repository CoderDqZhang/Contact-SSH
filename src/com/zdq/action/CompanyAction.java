package com.zdq.action;

import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import sun.misc.Request;

import com.opensymphony.xwork2.ActionSupport;
import com.zdq.dao.CompanyDao;
import com.zdq.dao.impl.CompanyDaoImp;
import com.zdq.model.Company;
import com.zdq.model.User;

public class CompanyAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String companyName;
	CompanyDao daoImp = new CompanyDaoImp();
	private Map<String,Object> dataMap;
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
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		System.out.println(request.getCharacterEncoding());
		String msg = URLDecoder.decode(companyName, "UTF-8");
		System.out.print("接受的参数"+companyName+msg);
		List<Company> companys = daoImp.getCompanyUser(companyName);
		dataMap = new HashMap<String, Object>();
		dataMap.clear();
		if (companys != null) {
			dataMap.put("companys", companys);  
	        // 放入一个是否操作成功的标识  
	        dataMap.put("success", true);
			return SUCCESS;
		}else{
			dataMap.put("faile", true);
    		return SUCCESS;
		}
	}
	public String getCompanyGroup() throws Exception{
		
		List<Company> companys = daoImp.getCompanuGroup(companyName);
		dataMap = new HashMap<String, Object>();
		dataMap.clear();
		if (companys != null) {
			dataMap.put("companys", companys);  
	        // 放入一个是否操作成功的标识  
	        dataMap.put("success", true);
			return SUCCESS;
		}else{
			dataMap.put("faile", true);
    		return SUCCESS;
		}
	}
}
