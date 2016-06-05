package com.zdq.action;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.zdq.dao.UserDao;
import com.zdq.dao.impl.UserDaoImp;
import com.zdq.model.User;

public class RegisterAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserDao dao = new UserDaoImp();
	private String username;
	private String password;
	private String company;
	private Map<String,Object> dataMap;
	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	private Map<String,Object> session;
	
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public Map<String, Object> getSession() {
		return session;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() throws Exception{
		System.out.println(username+password+company);
		dataMap = new HashMap<String, Object>();
		dataMap.clear();
		User user = new User();
		user.setUsername(username);
		user.setCompany(company);
		user.setPassword(password);
		String stateString = dao.save(user);
		dataMap.put("state", stateString); 
		return SUCCESS;
	        // 放入一个是否操作成功的标识  
	       
	}

}
