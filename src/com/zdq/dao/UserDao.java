package com.zdq.dao;

import java.util.List;

import com.zdq.model.User;

public interface UserDao {
	
	public void saveUser(User user);
	public List<User> getAll(Class clazz);
	public User isValidUser(String username,String password, String company);
	public User isValidAdmin(String username,String password, String company);
}
