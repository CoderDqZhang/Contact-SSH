package com.zdq.action;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.zdq.dao.UserDao;
import com.zdq.dao.impl.UserDaoImp;
import com.zdq.model.User;

public class LoginAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserDao dao = new UserDaoImp();
	
	private String key = "Just see see";

	private String username;
	private String password;
	private String company;
	private String newpassword;
	

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

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

	//设置key属性不作为json的内容返回  
    @JSON(serialize=false)  
    public String getKey() {  
        return key;  
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
  
	
	public String login(){
		System.out.println(username+password+company);
		dataMap = new HashMap<String, Object>();
		dataMap.clear();
		User user = dao.isValidUser(username, password,company);
		if(user!=null){
			dataMap.put("user", user);  
	        // 放入一个是否操作成功的标识  
	        dataMap.put("success", true);
    		return SUCCESS;
    	}else{
    		dataMap.put("faile", true);
    		return SUCCESS;
    	}  	
	}
	
	public String changePassword() {
		dataMap = new HashMap<String, Object>();
		dataMap.clear();
		User user = new User();
		user.setPassword(password);
		user.setUsername(username);
		user.setCompany(company);
		String stateString = dao.changePassword(user, newpassword);
		System.out.print("========="+username+"=========="+password+"======="+newpassword+"======="+company);
		if (stateString.equals("Success")) {
			dataMap.put("state", "Success");
    		return SUCCESS;
		}else {
			dataMap.put("state","faile");
    		return SUCCESS;
		}
		
	}
	

}
