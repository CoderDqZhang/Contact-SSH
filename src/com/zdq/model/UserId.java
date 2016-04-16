package com.zdq.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * UserId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class UserId implements java.io.Serializable {

	// Fields

	private String username;
	private String password;
	private String company;

	// Constructors

	/** default constructor */
	public UserId() {
	}

	/** full constructor */
	public UserId(String username, String password, String company) {
		this.username = username;
		this.password = password;
		this.company = company;
	}

	// Property accessors

	@Column(name = "username")
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "company")
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
		if (!(other instanceof UserId))
			return false;
		UserId castOther = (UserId) other;

		return ((this.getUsername() == castOther.getUsername()) || (this
				.getUsername() != null && castOther.getUsername() != null && this
				.getUsername().equals(castOther.getUsername())))
				&& ((this.getPassword() == castOther.getPassword()) || (this
						.getPassword() != null
						&& castOther.getPassword() != null && this
						.getPassword().equals(castOther.getPassword())))
				&& ((this.getCompany() == castOther.getCompany()) || (this
						.getCompany() != null && castOther.getCompany() != null && this
						.getCompany().equals(castOther.getCompany())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUsername() == null ? 0 : this.getUsername().hashCode());
		result = 37 * result
				+ (getPassword() == null ? 0 : this.getPassword().hashCode());
		result = 37 * result
				+ (getCompany() == null ? 0 : this.getCompany().hashCode());
		return result;
	}

}