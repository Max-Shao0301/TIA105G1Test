package com.admin.model;

import java.util.List;

public interface AdminDAO_Interface {
	public void insert(AdminVO adminVO);
	public void update(AdminVO adminVO);
	public void delete(Integer adminId);
	public AdminVO findByPrimaryKey(Integer adminId);
	public List<AdminVO> getAll();
	public AdminVO findByAccount(String account);
}
