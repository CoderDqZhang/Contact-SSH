package com.zdq.action;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.zdq.dao.UserDao;
import com.zdq.dao.impl.UserDaoImp;
import com.zdq.model.User;
import com.zdq.model.UserId;

public class RegisterAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserDao dao = new UserDaoImp();
	private String username;
	private String password;
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
		
		User user = new User();
		UserId userid = new UserId();
		userid.setUsername(username);
		userid.setPassword(password);
		user.setId(userid);
//		user.getId().setUsername(username);
//		user.getId().setPassword(password);
		dao.saveUser(user);
//    	User user = dao.isValidAdmin(username, password);
    	HttpServletResponse response = ServletActionContext.getResponse();
    	JSONObject jsonObject = new JSONObject();
        PrintWriter out  = response.getWriter();
		if(user!=null){
//    		System.out.print(user.getId().getUsername());
    		jsonObject = JSONObject.fromObject(user.getId());
    		System.out.print(jsonObject);
    		out.print(jsonObject);
    		out.flush();
    		out.close();
    		return SUCCESS;
    	}else{
    		jsonObject.put("code", "faile");
    	    out.println(jsonObject); 
    	    out.flush();
    	    out.close();
    		return SUCCESS;
    	}  	
	}

}
