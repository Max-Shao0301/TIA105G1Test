package com.apply.model;

import java.sql.Timestamp;
import java.util.List;

import com.staff.model.StaffDAO_interface;
import com.staff.model.StaffJDBCDAO;
import com.staff.model.StaffVO;

public class ApplyService {
	private ApplyDAO_interface dao;
	private StaffDAO_interface staffdao;

	public ApplyService() {
		dao = new ApplyJDBCDAO();
		staffdao = new StaffJDBCDAO();
		
	}
	
	public ApplyVO addApply(String email, String name, String phone, Integer gender,
			byte[] licencePhoto, String plateNumber, String introduction, Integer results,
			 Timestamp submissionDate, Timestamp reviewDate) {
		ApplyVO applyVO = new ApplyVO();
		applyVO.setEmail(email);
		applyVO.setName(name);
		applyVO.setPhone(phone);
		applyVO.setGender(gender);
		applyVO.setLicencePhoto(licencePhoto);
		applyVO.setPlateNumber(plateNumber);
		applyVO.setIntroduction(introduction);
		applyVO.setResults(results);
		applyVO.setSubmissionDate(submissionDate);
		applyVO.setReviewDate(reviewDate);
		dao.insert(applyVO);
		
		return applyVO;
		
		
	}
	public ApplyVO updateApply(Integer applyId, Integer results) {
		ApplyVO applyVO = dao.findByPrimaryKey(applyId);
		if (applyVO == null) {
			throw new IllegalArgumentException("找不到applyId");
		}
		StaffVO staffVO = new StaffVO();
		applyVO.setApplyId(applyId);
		applyVO.setResults(results);
		
		dao.update(applyVO);
		
		staffVO.setApply_id(applyVO.getApplyId());
		staffVO.setEmail(applyVO.getEmail());
		staffVO.setPassword("123456");
		staffVO.setName(applyVO.getName());
		staffVO.setPhone(applyVO.getPhone());
		staffVO.setGender(applyVO.getGender());
		staffVO.setPlate_number(applyVO.getPlateNumber());
		staffVO.setIntroduction(applyVO.getIntroduction());
		staffdao.add(staffVO);
		
		
		return applyVO;
		
	}
	
	public void deleteApply(Integer applyId) {
		dao.delete(applyId);
	}
	
	public ApplyVO getOneApply(Integer applyId) {
		return dao.findByPrimaryKey(applyId);
	}
	public List<ApplyVO> getAll(){
		return dao.getAll();
	}
	
	
	
	
}
