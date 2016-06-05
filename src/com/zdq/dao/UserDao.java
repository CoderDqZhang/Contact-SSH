package com.zdq.dao;

import java.util.List;

import com.zdq.model.Company;
import com.zdq.model.User;

public interface UserDao {
	
	public void saveUser(List<Company> user,String password);
	public String save(User user);
	public String changePassword(User user, String newpassword);
	public List<User> getAll(Class clazz);
	public User isValidUser(String username,String password, String company);
	public User isValidAdmin(String username,String password, String company);
}
