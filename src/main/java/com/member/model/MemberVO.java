package com.member.model;

import java.sql.Timestamp;

public class MemberVO {
	private Integer member_id;
	private String email;
	private String password;
	private String name;
	private String phone;
	private String address;
	private Integer points;
	private String captcha_code;
	private Integer status;
	private Timestamp registration_time;
	private Timestamp last_update_time;

	public Integer getMember_id() {
		return member_id;
	}

	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public String getCaptcha_code() {
		return captcha_code;
	}

	public void setCaptcha_code(String captcha_code) {
		this.captcha_code = captcha_code;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Timestamp getRegistration_time() {
		return registration_time;
	}

	public void setRegistration_time(Timestamp registration_time) {
		this.registration_time = registration_time;
	}

	public Timestamp getLast_update_time() {
		return last_update_time;
	}

	public void setLast_update_time(java.sql.Timestamp timestamp) {
		this.last_update_time = timestamp;
	}

	
}
