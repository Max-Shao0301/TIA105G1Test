package com.apply.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class ApplyVO implements Serializable {
	private Integer applyId;
	private String email;
	private String name;
	private String phone;
	private Integer gender;
	private byte[] licencePhoto;
	private String plateNumber;
	private String introduction;
	private Integer results;
	private Timestamp submissionDate;
	private Timestamp reviewDate;



	public ApplyVO() {
		
	}
	
	public ApplyVO(Integer applyId, String email, String name, String phone, Integer gender, byte[] licencePhoto,
			String plateNumber, String introduction, Integer results, Timestamp submissionDate, Timestamp reviewDate) {
		
		this.applyId = applyId;
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.gender = gender;
		this.licencePhoto = licencePhoto;
		this.plateNumber = plateNumber;
		this.introduction = introduction;
		this.results = results;
		this.submissionDate = submissionDate;
		this.reviewDate = reviewDate;
	}

	public Integer getApplyId() {
		return applyId;
	}
	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public byte[] getLicencePhoto() {
		return licencePhoto;
	}
	public void setLicencePhoto(byte[] licencePhoto) {
		this.licencePhoto = licencePhoto;
	}
	public String getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public Integer getResults() {
		return results;
	}
	public void setResults(Integer results) {
		this.results = results;
	}
	public Timestamp getSubmissionDate() {
		return submissionDate;
	}
	public void setSubmissionDate(Timestamp submissionDate) {
		this.submissionDate = submissionDate;
	}
	public Timestamp getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Timestamp reviewDate) {
		this.reviewDate = reviewDate;
	}

	
	
	
	
}
