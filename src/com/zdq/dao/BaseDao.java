package com.zdq.dao;

import java.util.List;

import javax.imageio.spi.ServiceRegistry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.*;

import com.sun.org.apache.xml.internal.security.Init;

public class BaseDao implements BaseDaoIntaceface {

	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	
	public void init() {
//		Configuration configuration = new Configuration().configure();
		sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    	
    	session = sessionFactory.openSession();
    	transaction = session.beginTransaction();
	}
	
	public Session getSession() {
		init();
		return session;
	}

	public void closeSession() {
		// TODO Auto-generated method stub
		session.close();
	}

	public List search(String hql) {
		// TODO Auto-generated method stub
		Session session = null;
		session = getSession();
		List alist = null;
		alist = session.createQuery(hql).list();
		session.close();
		return alist;
	}

}
