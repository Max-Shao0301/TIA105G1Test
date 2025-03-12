package com.member.model;

import java.util.List;

public class Testmain {
	public static void main(String[] args) {
		MemberDAO_interface dao = new MemberJDBCDAO();
//

//		
//		insert member
//		MemberVO member1 = new MemberVO();
//		member1.setEmail("hahakkn@gmail.com");
//		member1.setPassword("123");
//		member1.setAddress("台北市南京復興");
//		member1.setName("test");
//		member1.setPhone("0981234532");
//		member1.setCaptcha_code("1bej23");

//		dao.insert(member1);
//		System.out.println("資料增加完畢");
		
		//UPSATES
//		MemberVO member2 = new MemberVO();
//		member2.setMember_id(3);
//		member2.setAddress("新北市林口區");
//		member2.setEmail("1233211234@haha.com");
//		member2.setPassword("123333");
//		member2.setPhone("0912222222");
//		member2.setName("JANNIE");
//		member2.setStatus(1);
//		member2.setPoints(22);
//		
//		dao.update(member2);
//		
//		
//		System.out.println("資料修改完畢");
//		System.out.println(member2);
		
		//select_one
//		MemberVO member3 = dao.findbyPrimaryKey(2);
//		System.out.print(member3.getMember_id() + ",");
//		System.out.print(member3.getEmail() + ",");
//		System.out.print(member3.getPassword() + ",");
//		System.out.print(member3.getName() + ",");
//		System.out.print(member3.getPhone() + ",");
//		System.out.print(member3.getAddress() + ",");
//		System.out.print(member3.getPoints() + ",");
//		System.out.print(member3.getCaptcha_code() + ",");
//		System.out.print(member3.getStatus() + ",");
//		System.out.print(member3.getRegistration_time() + ",");
//		System.out.print(member3.getLast_update_time() );
//		
//		System.out.println();
//		//select_all
		List<MemberVO> list = dao.getAll();
		for (MemberVO member : list) {
			System.out.print(member.getMember_id() + ",");
			System.out.print(member.getEmail() + ",");
			System.out.print(member.getPassword() + ",");
			System.out.print(member.getName() + ",");
			System.out.print(member.getPhone() + ",");
			System.out.print(member.getAddress() + ",");
			System.out.print(member.getPoints() + ",");
			System.out.print(member.getCaptcha_code() + ",");
			System.out.print(member.getStatus() + ",");
			System.out.print(member.getRegistration_time() + ",");
			System.out.print(member.getLast_update_time() );
			
			
			System.out.println();}

	}
}
