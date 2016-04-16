package com.zdq.dao.impl;

import java.util.List;

import org.apache.derby.tools.sysinfo;

import com.zdq.dao.BaseDao;
import com.zdq.dao.UserDao;
import com.zdq.model.User;

public class UserDaoImp extends BaseDao implements UserDao {

	public void saveUser(User user) {
		// TODO Auto-generated method stub
		super.getSession().save(user);//保存后customer对象处于持久化状态
//		super.getSession().flush();
		super.getTransaction().commit();
		super.getSession().close();
	}

	public List<User> getAll(Class clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	public User isValidUser(String username, String password, String company) {
		// TODO Auto-generated method stub
		User user = null;
		System.out.println("dfdsf"+username+password);
		List<User> list = super.search("FROM User WHERE username ='"+username+"'AND password = '"+password+"'");
		if(list!=null && list.size()>0){
			user = list.get(0);
		}
		return user;
	}

	
	public User isValidAdmin(String username, String password, String company) {
		User user = null;
		System.out.println("dfdsf"+username+password);
		List<User> list = super.search("FROM User WHERE username ='"+username+"' AND password = '"+password+"' AND company = '"+company+"'");
		if(list!=null && list.size()>0){
			user = list.get(0);
		}
		return user;
	}

}
