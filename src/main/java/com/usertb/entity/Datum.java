package com.usertb.entity;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 用户资料表
 */
@Component
public class Datum {
	private Integer uid;// user id
	private String phone;// user phone
	private String name;// 名字
	private Integer gender;// 性别
	private String birthday;// 生日
	private String photo;// 头像

	public Datum() {}

	public Datum(String phone, String name, Integer gender, String birthday, String photo) {
		this.phone = phone;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Datum{" +
				"uid=" + uid +
				", phone='" + phone + '\'' +
				", name='" + name + '\'' +
				", gender=" + gender +
				", birthday=" + birthday +
				", photo='" + photo + '\'' +
				'}';
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
