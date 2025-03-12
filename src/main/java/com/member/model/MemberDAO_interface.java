package com.member.model;

import java.util.List;

public interface MemberDAO_interface {
	public void insert(MemberVO memberVO);
	public void update(MemberVO memberVO);
	public void update_account(MemberVO memberVO);
	public void update_password(MemberVO memberVO);
	public void update_points(MemberVO memberVO);
	public void update_captcha_code(MemberVO memberVO);	
	public void delete(MemberVO memberVO);

	public MemberVO findbyPrimaryKey(Integer member_id);

	public List<MemberVO> getAll();
}
