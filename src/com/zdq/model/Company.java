package com.zdq.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Company entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Company", catalog = "Contact")
public class Company implements java.io.Serializable {

	// Fields

	private CompanyId id;

	// Constructors

	/** default constructor */
	public Company() {
	}

	/** full constructor */
	public Company(CompanyId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "username", column = @Column(name = "username", nullable = false)),
			@AttributeOverride(name = "phone", column = @Column(name = "phone", nullable = false)),
			@AttributeOverride(name = "home", column = @Column(name = "home")),
			@AttributeOverride(name = "department", column = @Column(name = "department", nullable = false)),
			@AttributeOverride(name = "position", column = @Column(name = "position", nullable = false)),
			@AttributeOverride(name = "qq", column = @Column(name = "qq", length = 20)),
			@AttributeOverride(name = "email", column = @Column(name = "email")),
			@AttributeOverride(name = "age", column = @Column(name = "age")),
			@AttributeOverride(name = "company", column = @Column(name = "company", nullable = false)) })
	public CompanyId getId() {
		return this.id;
	}

	public void setId(CompanyId id) {
		this.id = id;
	}

}