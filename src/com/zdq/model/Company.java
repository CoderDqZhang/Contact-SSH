package com.zdq.model;

/**
 * Company entity. @author MyEclipse Persistence Tools
 */

public class Company implements java.io.Serializable {

	// Fields

	private String phone;
	private String username;
	private String home;
	private String department;
	private String position;
	private String qq;
	private String email;
	private Integer age;
	private String company;
	private Integer sortId;

	// Constructors

	/** default constructor */
	public Company() {
	}

	/** minimal constructor */
	public Company(String phone, String company) {
		this.phone = phone;
		this.company = company;
	}

	/** full constructor */
	public Company(String phone, String username, String home,
			String department, String position, String qq, String email,
			Integer age, String company, Integer sortId) {
		this.phone = phone;
		this.username = username;
		this.home = home;
		this.department = department;
		this.position = position;
		this.qq = qq;
		this.email = email;
		this.age = age;
		this.company = company;
		this.sortId = sortId;
	}

	// Property accessors

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getHome() {
		return this.home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Integer getSortId() {
		return this.sortId;
	}

	public void setSortId(Integer sortId) {
		this.sortId = sortId;
	}

}