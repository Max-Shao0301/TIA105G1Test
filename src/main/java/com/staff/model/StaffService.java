package com.staff.model;

import java.util.List;

public class StaffService {
	private StaffDAO_interface dao;

	public StaffService() {
		dao = new StaffJDBCDAO();
	}

	public void addStaff(Integer apply_id, String email, String password, String name, String phone, Integer gender,
			String plate_number, String introduction) {

		StaffVO staff = new StaffVO();
		staff.setApply_id(apply_id);
		staff.setEmail(email);
		staff.setPassword(password);
		staff.setName(name);
		staff.setPhone(phone);
		staff.setGender(gender);
		staff.setPlate_number(plate_number);
		staff.setIntroduction(introduction);

		dao.add(staff);
	}

	public StaffVO updateStaff(String email, String password, String name, String phone, String plate_number,
			String introduction, Integer staff_id) {

		StaffVO staff = new StaffVO();
		staff.setEmail(email);
		staff.setPassword(password);
		staff.setName(name);
		staff.setPhone(phone);
		staff.setPlate_number(plate_number);
		staff.setIntroduction(introduction);
		staff.setStaff_id(staff_id);
		
		dao.update(staff);
		return staff;

	}

//
	public StaffVO deleteStaff(Integer staff_id) {
		StaffVO staffVO = new StaffVO();
		staffVO.setStaff_id(staff_id);
		dao.delete(staffVO);
		
		return staffVO;
	}

//
	public StaffVO getOneStaff(Integer staff_id) {
		return dao.findByPK(staff_id);
	}

//
	public List<StaffVO> getAll() {
		return dao.getAll();
	}
}
