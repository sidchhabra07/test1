package com.project.accountmanagement.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class Users {
	@Id
	@Column(name="userId")
	private int userId;
	
	@Column(name="password" , columnDefinition = "varchar(255) default '000000'")
	private String password;
	
	@Column(name="roleId")
	private int roleId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public Users() {
		super();
	}

	public Users(int userId, String password, int roleId) {
		super();
		this.userId = userId;
		this.password = password;
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", password=" + password + ", roleId=" + roleId + "]";
	}
	
	
}
