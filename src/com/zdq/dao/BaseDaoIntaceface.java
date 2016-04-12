package com.zdq.dao;

import java.util.List;

import org.hibernate.Session;

public interface BaseDaoIntaceface {
	public Session getSession();
	public void closeSession();
	public List search(String hql);
}
