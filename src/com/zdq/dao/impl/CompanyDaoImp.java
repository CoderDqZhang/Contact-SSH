package com.zdq.dao.impl;

import java.util.List;

import org.hibernate.AnnotationException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.zdq.dao.BaseDao;
import com.zdq.dao.CompanyDao;
import com.zdq.model.Company;
import com.zdq.model.IBaseHibernateDAO;
import com.zdq.model.User;

public class CompanyDaoImp extends BaseDao implements CompanyDao{

	private SessionFactory sessionFactory;
	Configuration configuration=new Configuration(); 
	SessionFactory sf=configuration.configure().buildSessionFactory();
	Session session=sf.openSession(); 
	
    public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void saveCompany(List<Company> company) {
		// TODO Auto-generated method stub
		
		Transaction tx=session.beginTransaction();
		for(Company tmp:company){
			System.out.print("fdsdfsd");
			session.save(tmp);//保存后customer对象处于持久化状态
			session.flush();//清空缓存后customer对象处于游离状态
			tx.commit();
//			String sql = "insert into Company(username,phone,home,department,position,\n" +
//					"qq,email,age,company) values('"+tmp.getId().getUsername()+"',\n" +
//							"'"+tmp.getId().getPhone()+"','"+tmp.getId().getHome()+"',\n" +
//									"'"+tmp.getId().getDepartment()+"',\n" +
//											"'"+tmp.getId().getPosition()+"',\n" +
//													"'"+tmp.getId().getQq()+"',\n" +
//															"'"+tmp.getId().getEmail()+"'," +
//					"\n'"+tmp.getId().getAge()+"','"+tmp.getId().getCompany()+"')";
//			SQLQuery query = this.getSession().createSQLQuery(sql);
		}
		session.close();
	}

}
