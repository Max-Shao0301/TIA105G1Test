package com.member.model;

import java.util.List;

public class MemberService {
	
	private MemberDAO_interface dao;
	
	public MemberService() {
		dao = new MemberJDBCDAO();
	}
	
	public MemberVO deleteMember(Integer member_id) {
		MemberVO memberVO = new MemberVO();
		memberVO.setMember_id(member_id);
		dao.delete(memberVO);
		
		return memberVO;
	}
	
	public MemberVO addMember(String email, String password,String name,String phone,
								String address,String captcha_code) {
		MemberVO memberVO = new MemberVO();
		memberVO.setEmail(email);
		memberVO.setPassword(password);
		memberVO.setName(name);
		memberVO.setPhone(phone);
		memberVO.setAddress(address);
		memberVO.setCaptcha_code(captcha_code);
		
		dao.update(memberVO);
		
		return memberVO;
	}
	
	public MemberVO updateMember(Integer member_id, String email, String password, String name, String phone,
								String address,Integer points,Integer status, String captcha_code) {
		
		MemberVO memberVO = new MemberVO();
		memberVO.setEmail(email);
		memberVO.setPassword(password);
		memberVO.setName(name);
		memberVO.setPhone(phone);
		memberVO.setAddress(address);
		memberVO.setPoints(points);
		memberVO.setStatus(status);
		memberVO.setCaptcha_code(captcha_code);
		
		dao.update(memberVO);
		
		return memberVO;
	}
	
	public MemberVO updateMemberAccount(Integer member_id, String email, String name, String phone,
					String address) {
		
		MemberVO memberVO = new MemberVO();
		memberVO.setEmail(email);
		memberVO.setName(name);
		memberVO.setPhone(phone);
		memberVO.setAddress(address);
		
		dao.update_account(memberVO);
		return memberVO;
		}
	
	public MemberVO updateMemberPassword(String password) {
		
		MemberVO memberVO = new MemberVO();

		memberVO.setPassword(password);
		
		dao.update_password(memberVO);
		return memberVO;
		}
	
	public MemberVO updateMemberCaptchaCode(String captcha_code) {

		MemberVO memberVO = new MemberVO();

		memberVO.setCaptcha_code(captcha_code);
		
		dao.update_captcha_code(memberVO);
		
		return memberVO;
		}
	
	public MemberVO updateMemberPoints(Integer points) {

		MemberVO memberVO = new MemberVO();
		
		memberVO.setPoints(points);
		
		dao.update_points(memberVO);
		
		return memberVO;
		}
	
	public MemberVO getOneMember(Integer member_id) {
	
		return dao.findbyPrimaryKey(member_id);
	}
	
	public List<MemberVO> getAll(){
		return dao.getAll();
	}
	
}
