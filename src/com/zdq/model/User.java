package com.zdq.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "User", catalog = "Contact")
public class User implements java.io.Serializable {

	// Fields

	private UserId id;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(UserId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "username", column = @Column(name = "username")),
			@AttributeOverride(name = "password", column = @Column(name = "password")),
			@AttributeOverride(name = "company", column = @Column(name = "company")) })
	public UserId getId() {
		return this.id;
	}

	public void setId(UserId id) {
		this.id = id;
	}

}