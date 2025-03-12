package com.apply.model;

import java.io.FileInputStream;
import java.io.IOException;



public class ApplyTest {
	//上傳圖片
	public static byte[] getPictureByteArray(String path) {
		FileInputStream fis = null;
		byte [] buffer = null;
		
		try {
			fis = new FileInputStream(path);
			buffer = new byte[fis.available()];
			fis.read(buffer);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return buffer;
	}
	
	public static void main(String[] args) {
		ApplyDAO_interface dao = new ApplyJDBCDAO();
		
		//insert
		ApplyVO applyVO = new ApplyVO();
		applyVO.setEmail("Bank@icloud.com");
		applyVO.setName("Bank");
		applyVO.setPhone("0963224171");
		applyVO.setGender(1);
		byte[] licence_photo = getPictureByteArray("src/main/webapp/resource/images/lic3.jpeg");
		applyVO.setLicencePhoto(licence_photo);
		applyVO.setPlateNumber("BCA7393");
		applyVO.setIntroduction("I'm Bank, Hello!");
		dao.insert(applyVO);
		
		//update
//		ApplyVO applyVO = new ApplyVO();
//		applyVO.setResults(1);
//		applyVO.setApplyId(1);
//		dao.update(applyVO);
		
		
		
		//delete
//		dao.delete(1);
		
		//findByPK
//		ApplyVO applyVO = dao.findByPrimaryKey(2);
//		System.out.println(applyVO.getEmail());
//		System.out.println(applyVO.getName());
//		System.out.println(applyVO.getPhone());
//		System.out.println(applyVO.getGender());
//		System.out.println(applyVO.getLicencePhoto());
//		System.out.println(applyVO.getPlateNumber());
//		System.out.println(applyVO.getIntroduction());
//		System.out.println(applyVO.getResults());
//		System.out.println(applyVO.getSubmissionDate());
//		System.out.println(applyVO.getReviewDate());
		
		//getAll
//		List<ApplyVO> list = dao.getAll();
//		for(ApplyVO applyVO: list) {
//			System.out.println(applyVO.getApplyId());
//			System.out.println(applyVO.getEmail());
//			System.out.println(applyVO.getName());
//			System.out.println(applyVO.getPhone());
//			System.out.println(applyVO.getGender());
//			System.out.println(applyVO.getLicencePhoto());
//			System.out.println(applyVO.getPlateNumber());
//			System.out.println(applyVO.getIntroduction());
//			System.out.println(applyVO.getResults());
//			System.out.println(applyVO.getSubmissionDate());
//			System.out.println(applyVO.getReviewDate());
//		}
	}

}

