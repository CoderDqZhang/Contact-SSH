package com.zdq.dao.impl;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.hibernate.AnnotationException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.zdq.dao.BaseDao;
import com.zdq.dao.CompanyDao;
import com.zdq.java.tool.ChangeCharset;
import com.zdq.model.Company;
import com.zdq.model.CompanyId;
import com.zdq.model.IBaseHibernateDAO;
import com.zdq.model.User;
//String sql = "insert into Company(username,phone,home,department,position,\n" +
//		"qq,email,age,company) values('"+tmp.getId().getUsername()+"',\n" +
//				"'"+tmp.getId().getPhone()+"','"+tmp.getId().getHome()+"',\n" +
//						"'"+tmp.getId().getDepartment()+"',\n" +
//								"'"+tmp.getId().getPosition()+"',\n" +
//										"'"+tmp.getId().getQq()+"',\n" +
//												"'"+tmp.getId().getEmail()+"'," +
//		"\n'"+tmp.getId().getAge()+"','"+tmp.getId().getCompany()+"')";
//SQLQuery query = this.getSession().createSQLQuery(sql);

public class CompanyDaoImp extends BaseDao implements CompanyDao{
	
	public void saveCompany(List<Company> company) {
		// TODO Auto-generated method stub
		for(Company tmp:company){
			System.out.println(tmp.getId().getUsername());
			super.getSession().save(tmp);//保存后customer对象处于持久化状态
			super.getTransaction().commit();
		}
		super.getSession().close();
	}
	/**
	 * 检查数据库中时候有company表
	 */
	
	public Bool hasCompanyTable(String tableName) {
		// TODO Auto-generated method stub
		
		return null;
	}
	public void importUserToDB(List<Company> company) {
		// TODO Auto-generated method stub
		
	}
	public List<String> companyName() {
		// TODO Auto-generated method stub
//		super.search("FROM Company WHERE username = *");
		String sql = "SELECT * FROM Company";
//		String sql = "SELECT home FROM Company";
		List<String> name = super.search(sql);
		if(name.size()<0){
			return null;
		}else{
			return name;
		}
	}
	public List<Company> getCompanyUser(String companyName) {
		List<Company> companys = null;
		String companyUTF = "";
		System.out.print("接受的参数"+companyName);
		ChangeCharset changeCharset = new ChangeCharset();
		try {
			companyUTF = changeCharset.toUTF_8(companyName);
			
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			companyUTF = "";
			e1.printStackTrace();
//			return null;
		};
		System.out.print("fsdgdsdgs"+companyUTF);
//		companyUTF = "观微科技";
		System.out.print("fsdgdsdgs"+companyUTF);
		companys = super.search("FROM Company WHERE company ='"+companyUTF+"'");
		if(companys!=null && companys.size()>0){
			return companys;
		}else{
			return null;
		}
	}
	public List<Company> getCompanuGroup(String companyName) {
		// TODO Auto-generated method stub
		List<Company> companys = null;
		String companyUTF = "";
		ChangeCharset changeCharset = new ChangeCharset();
		try {
			companyUTF = changeCharset.toUTF_8(companyName);
			
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			companyUTF = "";
			e1.printStackTrace();
//			return null;
		};	
		companys = super.search("SELECT count(*), department FROM Company group by department");
		if(companys!=null && companys.size()>0){
			return companys;
		}else{
			return null;
		}
	}

}
