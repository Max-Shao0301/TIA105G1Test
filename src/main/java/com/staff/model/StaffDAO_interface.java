package com.staff.model;

import java.util.List;


public interface StaffDAO_interface {
	public void add (StaffVO staff);
	public void update (StaffVO staff);
	public void delete(StaffVO staffVO);
	
//	單筆查詢
	public StaffVO findByPK(Integer staffId);

//	多筆查詢
	public List<StaffVO> getAll();
}
