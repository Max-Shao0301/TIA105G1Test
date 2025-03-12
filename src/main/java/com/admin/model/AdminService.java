package com.admin.model;

import java.util.List;

public class AdminService {
	
	private AdminDAO_Interface dao;
	
	public AdminService() {
		dao = new AdminJDBCDAO();
	}
	
	public AdminVO addAdmin(String account, String password) {
		AdminVO adminVO = new AdminVO();
		adminVO.setAccount(account);
		adminVO.setPassword(password);
		dao.insert(adminVO);
		
		return adminVO;
	}
	public AdminVO updateAdmin(String account, String password) {
		AdminVO adminVO = new AdminVO();
		adminVO.setAccount(account);
		adminVO.setPassword(password);
		dao.update(adminVO);
		
		return adminVO;
	}
	public void deleteAdmin(Integer adminId) {
		dao.delete(adminId);
	}
	public AdminVO getOneAdmin(Integer admiinId) {
		return dao.findByPrimaryKey(admiinId);
	}
	public List<AdminVO> getAll() {
		return dao.getAll();
	}
	
	public AdminVO findByAccount(String account) {
		return dao.findByAccount(account);
	}
	
}
