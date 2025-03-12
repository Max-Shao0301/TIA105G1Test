package com.admin.model;

import java.io.Serializable;

public class AdminVO implements Serializable {
	private Integer adminId;
	private String account;
	private String password;
	
	
	
	public AdminVO() {
	
	}
	
	public AdminVO(Integer adminId, String account, String password) {
		this.adminId = adminId;
		this.account = account;
		this.password = password;
	}

	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
