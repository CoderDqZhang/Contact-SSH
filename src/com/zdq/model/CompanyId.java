package com.zdq.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CompanyId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class CompanyId implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String phone;
	private String home;
	private String department;
	private String position;
	private String qq;
	private String email;
	private Integer age;
	private String company;

	// Constructors

	/** default constructor */
	public CompanyId() {
	}

	/** minimal constructor */
	public CompanyId(String username, String phone, String department,
			String position, String company) {
		this.username = username;
		this.phone = phone;
		this.department = department;
		this.position = position;
		this.company = company;
	}

	/** full constructor */
	public CompanyId(String username, String phone, String home,
			String department, String position, String qq, String email,
			Integer age, String company) {
		this.username = username;
		this.phone = phone;
		this.home = home;
		this.department = department;
		this.position = position;
		this.qq = qq;
		this.email = email;
		this.age = age;
		this.company = company;
	}

	// Property accessors

	@Column(name = "username", nullable = false)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "phone", nullable = false)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "home")
	public String getHome() {
		return this.home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	@Column(name = "department", nullable = false)
	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Column(name = "position", nullable = false)
	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Column(name = "qq", length = 20)
	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	@Column(name = "email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "age")
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Column(name = "company", nullable = false)
	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CompanyId))
			return false;
		CompanyId castOther = (CompanyId) other;

		return ((this.getUsername() == castOther.getUsername()) || (this
				.getUsername() != null && castOther.getUsername() != null && this
				.getUsername().equals(castOther.getUsername())))
				&& ((this.getPhone() == castOther.getPhone()) || (this
						.getPhone() != null && castOther.getPhone() != null && this
						.getPhone().equals(castOther.getPhone())))
				&& ((this.getHome() == castOther.getHome()) || (this.getHome() != null
						&& castOther.getHome() != null && this.getHome()
						.equals(castOther.getHome())))
				&& ((this.getDepartment() == castOther.getDepartment()) || (this
						.getDepartment() != null
						&& castOther.getDepartment() != null && this
						.getDepartment().equals(castOther.getDepartment())))
				&& ((this.getPosition() == castOther.getPosition()) || (this
						.getPosition() != null
						&& castOther.getPosition() != null && this
						.getPosition().equals(castOther.getPosition())))
				&& ((this.getQq() == castOther.getQq()) || (this.getQq() != null
						&& castOther.getQq() != null && this.getQq().equals(
						castOther.getQq())))
				&& ((this.getEmail() == castOther.getEmail()) || (this
						.getEmail() != null && castOther.getEmail() != null && this
						.getEmail().equals(castOther.getEmail())))
				&& ((this.getAge() == castOther.getAge()) || (this.getAge() != null
						&& castOther.getAge() != null && this.getAge().equals(
						castOther.getAge())))
				&& ((this.getCompany() == castOther.getCompany()) || (this
						.getCompany() != null && castOther.getCompany() != null && this
						.getCompany().equals(castOther.getCompany())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUsername() == null ? 0 : this.getUsername().hashCode());
		result = 37 * result
				+ (getPhone() == null ? 0 : this.getPhone().hashCode());
		result = 37 * result
				+ (getHome() == null ? 0 : this.getHome().hashCode());
		result = 37
				* result
				+ (getDepartment() == null ? 0 : this.getDepartment()
						.hashCode());
		result = 37 * result
				+ (getPosition() == null ? 0 : this.getPosition().hashCode());
		result = 37 * result + (getQq() == null ? 0 : this.getQq().hashCode());
		result = 37 * result
				+ (getEmail() == null ? 0 : this.getEmail().hashCode());
		result = 37 * result
				+ (getAge() == null ? 0 : this.getAge().hashCode());
		result = 37 * result
				+ (getCompany() == null ? 0 : this.getCompany().hashCode());
		return result;
	}

}