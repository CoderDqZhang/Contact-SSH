package com.zdq.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.criterion.Projections;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.zdq.dao.BaseDao;
import com.zdq.dao.CompanyDao;
import com.zdq.model.Company;
import com.zdq.model.MapModel;
import com.zdq.model.User;

public class CompanyDaoImp extends BaseDao implements CompanyDao{
	public int count = 0;
	public void saveCompany(List<Company> company) {
		// TODO Auto-generated method stub
//		Transaction tx = super.getSession().beginTransaction();

		// TODO Auto-generated method stub
				for(Company tmp:company){
					count ++;
					super.getSession().saveOrUpdate(tmp);//保存后customer对象处于持久化状态
					super.getTransaction().commit();
//					if(company.size() > 50){
//						super.getSession().flush();
//						super.getSession().clear();
//						super.getTransaction().commit();
//					}else {
//						
//					}
				}
				super.getSession().close();
//		for(Company tmp:company){
//			count ++;
//			super.getSession().saveOrUpdate(tmp);
//			if(company.size() > 50){
//				if (count%50 == 0) {
//					super.getSession().flush();
//					super.getSession().clear();
//		            tx.commit();
//				}
//			}else if (count == company.size() - 1) {
//				tx.commit();
//			}
//			
//		}
//		super.getSession().flush();
//		super.getSession().clear();
//		count = 0;
//		super.getSession().close();
	}
	/**
	 * 检查数据库中时候有company表
	 */
	public Bool hasCompanyTable(String tableName) {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	private Company isCompany() throws Exception
	{
	    //查询出User表中的所有记录
	    ScrollableResults users = super.getSession().createQuery("from Company")
	        .setCacheMode(CacheMode.IGNORE)
	        .scroll(ScrollMode.FORWARD_ONLY);
	    //遍历User表中的全部记录
	    if (users.next()) {
	    	User u = (User) users.get(0);
	        return (Company)users.get(0);
		}else{
			return null;
	    }
	    
	}
	
	public void importUserToDB(List<Company> company) {
		// TODO Auto-generated method stub
		
	}
	public List<String> companyName() {
		// TODO Auto-generated method stub
		Criteria criteria = super.getSession().createCriteria(Company.class);
		criteria.setProjection(Projections.groupProperty("company"));
		List list = criteria.list();
		List<String> companyName = new ArrayList<String>();
		for(int i=0;i<list.size();i++){  
			Object arr = null;
		    arr = (Object)list.get(i);
		    companyName.add(arr.toString());
		    System.out.println(arr.toString());  
		}
		return companyName;
	}
	@SuppressWarnings("null")
	public List<Company> getCompanyUser(String companyName) {
		List<Company> companys = null;
		companys = super.search("FROM Company WHERE company ='"+companyName+"' order by sortId" );
		if(companys!=null && companys.size()>0){
			return companys;
		}else{
			return null;
		}
	}
	public Map<String,List<MapModel>> getCompanuGroup(String companyName) {
		// TODO Auto-generated method stub
		Map<String,List<MapModel>> map=new HashMap<String,List<MapModel>>();
		List<MapModel> listMapModels  = new ArrayList<MapModel>();
		System.out.print("＝＝＝＝＝＝＝＝＝＝＝"+companyName);
	    List<Company> allCompany = super.search("FROM Company WHERE company = '"+companyName+"'");
	    List<String> departmentStrings = new ArrayList<String>();
	    for (int i = 0; i < allCompany.size(); i++) {
	    	System.out.println("====="+allCompany.get(i).getDepartment());
	    	departmentStrings.add(allCompany.get(i).getDepartment());
		}
	    
	    HashSet hashSet = new HashSet(departmentStrings);
	    departmentStrings.clear();
	    departmentStrings.addAll(hashSet);
	    System.out.println(departmentStrings.size());
	    for (int i = 0; i < departmentStrings.size(); i++) {
	    	System.out.println(departmentStrings.get(i));
	    	List<Company> companys = new ArrayList<Company>();
	    	MapModel mapModel = new MapModel();
			for (int j = 0; j < allCompany.size(); j++) {
				Company company = allCompany.get(j);
				if (company.getDepartment().equals(departmentStrings.get(i))) {
					companys.add(company);
				}
			}
			mapModel.setContactsGroup(companys);
		    mapModel.setDepartmnet(departmentStrings.get(i));
		    listMapModels.add(mapModel);
		}
//		Criteria criteria = super.getSession().createCriteria(Company.class);
////		Criteria.setProjection(Projections.property(propertyName))
//		criteria.setProjection(Projections.groupProperty("department"));
//		List list = criteria.list();
//		for(int i=0;i<list.size();i++){  
//			Object arr = null;
//			MapModel mapModel = new MapModel();
//		    arr = (Object)list.get(i);
//		    List<Company> value = departmentGroup(arr.toString(),companyName);
//		    if(value == null){
//		    	value=new ArrayList<Company>();
//		    }else{
//		    	mapModel.setContactsGroup(value);
//			    mapModel.setDepartmnet(arr.toString());
//			    listMapModels.add(mapModel);
//		    }
//		    super.getSession().close();
//		} 
//		
		map.put("groups", listMapModels);
		return map;
}

public List<Company> departmentGroup(String department,String companyName){
	List<Company> deparCompany = null;
	companyName = "观微科技";
	System.out.print("========="+companyName);
	department = "应用部";
	deparCompany = super.search("FROM Company WHERE department ='"+department+"'AND company = '"+companyName+"'");
	if(deparCompany != null && deparCompany.size() > 0){
		return deparCompany;
	}else{
		return null;
	}
}

public Company isValidUser(String phone, String companyName) {
	// TODO Auto-generated method stub
	Company company = null;
	List<Company> list = super.search("FROM Company WHERE phone ='"+phone+"'AND company = '"+companyName+"'");
	if(list!=null && list.size()>0){
		company = list.get(0);
	}
	return company;
}

public boolean updateContact(Company company) {
	// TODO Auto-generated method stub
	Company tmpCompany = isValidUser(company.getPhone(), company.getCompany());
	if (tmpCompany != null) {
		try{
			super.getSession().saveOrUpdate(company);
			super.getTransaction().commit();
			super.getSession().close();
			return true;
		}catch (HibernateException e) {
			return false;
		}
	}else{
		return false;
	}
}


}
