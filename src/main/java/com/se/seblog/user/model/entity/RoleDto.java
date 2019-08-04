package com.se.seblog.user.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class RoleDto {

	/** role_id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	/** role name */
	@Column(name = "role", nullable = false)
	private String role;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}