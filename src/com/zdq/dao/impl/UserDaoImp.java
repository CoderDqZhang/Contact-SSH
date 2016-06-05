package com.zdq.dao.impl;

import java.util.List;

import org.apache.derby.tools.sysinfo;
import org.hibernate.Transaction;
import org.omg.CORBA.PUBLIC_MEMBER;

import com.sun.org.apache.xpath.internal.axes.SelfIteratorNoPredicate;
import com.zdq.dao.BaseDao;
import com.zdq.dao.UserDao;
import com.zdq.model.Company;
import com.zdq.model.User;

public class UserDaoImp extends BaseDao implements UserDao {

	public int count = 0;
	public void saveUser(List<Company> user,String password) {
		// TODO Auto-generated method stub
		for(Company tmp:user){
			count ++;
//			super.getSession().saveOrUpdate(tmp);//保存后customer对象处于持久化状态
//			super.getTransaction().commit();
//			if (count%50 == 0) {
//				super.getSession().flush();
//				super.getSession().clear();
//	            tx.commit();
//	            System.out.println(count);
//	            tx = super.getSession().beginTransaction();
//			}
			User tmpUser = new User();
			tmpUser.setCompany(tmp.getCompany());
			tmpUser.setUsername(tmp.getPhone());
			tmpUser.setPassword(password);
//			System.out.println(tmp.getId().getCompany()+tmp.getId().getPhone());
			super.getSession().saveOrUpdate(tmpUser);//保存后customer对象处于持久化状态
			super.getTransaction().commit();
		}
		super.getSession().flush();
		super.getSession().clear();
		count = 0;
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
		List<User> list = super.search("FROM User WHERE username ='"+username+"'AND password = '"+password+"'AND company = '"+company+"'");
		if(list!=null && list.size()>0){
			user = list.get(0);
		}
		return user;
	}

	
	public User isValidAdmin(String username, String password, String company) {
		User user = null;
		List<User> list = super.search("FROM User WHERE username ='"+username+"' AND password = '"+password+"' AND company = '"+company+"'");
		if(list!=null && list.size()>0){
			user = list.get(0);
		}
		return user;
	}

	public String save(User user) {
		// TODO Auto-generated method stub
		String stateString = "";
		try {
			super.getSession().saveOrUpdate(user);
			super.getTransaction().commit();
			super.getSession().close();
			stateString = "Success";
		} catch (Exception e) {
			stateString = "faile";
			// TODO: handle exception
		}
		return stateString;
	}

	public String changePassword(User user, String newpassword) {
		// TODO Auto-generated method stub
		String stateString = "";
		user = isValidUser(user.getUsername(), user.getPassword(), user.getCompany());
		if (user != null) {
			try {
				user.setPassword(newpassword);
				super.getSession().saveOrUpdate(user);//保存后customer对象处于持久化状态
				super.getTransaction().commit();
				super.getSession().close();
				stateString = "Success";
			} catch (Exception e) {
				stateString = "Faile";
				// TODO: handle exception
			}
			return stateString;
		}else{
			return "Faile";
		}
		
	}

}
