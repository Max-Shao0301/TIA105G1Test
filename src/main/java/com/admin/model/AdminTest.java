package com.admin.model;

import java.util.List;

public class AdminTest {
	public static void main(String[] args) {
		AdminDAO_Interface dao = new AdminJDBCDAO();
		
		
		//insert
		AdminVO adminVO =new AdminVO();
		adminVO.setAccount("admin");
		adminVO.setPassword("admin");
		dao.insert(adminVO);
		
//		update
//		AdminVO adminVO =new AdminVO();
//		adminVO.setAccount("admin");
//		adminVO.setPassword("admin");
//		adminVO.setAdminId(1);
//		dao.update(adminVO);
		
		//delete
//		dao.delete(1);
		
		//findByPK
//		AdminVO adminVO = dao.findByPrimaryKey(1);
//		System.out.println(adminVO.getAccount());
//		System.out.println(adminVO.getPassword());
		
		//findAll
//		List<AdminVO> list = dao.getAll();
//		for(AdminVO adminVO : list ) {
//			System.out.println(adminVO.getAdminId());
//			System.out.println(adminVO.getAccount());
//			System.out.println(adminVO.getPassword());
//			System.out.println("-----");
//		}
	
	}
}
