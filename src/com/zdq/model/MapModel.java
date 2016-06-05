package com.zdq.model;

import java.util.List;

public class MapModel {
	private List<Company> contactsGroup;
	private String departmnet;
	
	public List<Company> getContactsGroup() {
		return contactsGroup;
	}

	public void setContactsGroup(List<Company> contactsGroup) {
		this.contactsGroup = contactsGroup;
	}

	public String getDepartmnet() {
		return departmnet;
	}
	
	public void setDepartmnet(String departmnet) {
		this.departmnet = departmnet;
	}
}
