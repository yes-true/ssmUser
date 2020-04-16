package com.usertb.entity;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

/**
 * 用户表
 */
@Component
public class User {

	private Integer id;
	private String menbername;// 会员名
	private String password;// 密码
	private String phone;// 电话
	private String email;// 邮箱
	private Timestamp atime;// 添加时间
	private Timestamp utime;// 修改时间

	private Rightcontrol rightcontrol;
	private List<Site> sites;
	private Datum datum;

	public User() {}

	public User(Integer id, String menbername, String password, String phone, String email, Timestamp atime, Timestamp utime) {
		this.id = id;
		this.menbername = menbername;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.atime = atime;
		this.utime = utime;
	}

	public User(Integer id, String password, String phone, String email, Timestamp utime) {
		this.id = id;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.utime = utime;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", menbername='" + menbername + '\'' +
				", password='" + password + '\'' +
				", phone='" + phone + '\'' +
				", email='" + email + '\'' +
				", atime=" + atime +
				", utime=" + utime +
				", rightcontrol=" + rightcontrol +
				", sites=" + sites +
				", datum=" + datum +
				'}';
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMenbername() {
		return menbername;
	}

	public void setMenbername(String menbername) {
		this.menbername = menbername;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getAtime() {
		return atime;
	}

	public void setAtime(Timestamp atime) {
		this.atime = atime;
	}

	public Timestamp getUtime() {
		return utime;
	}

	public void setUtime(Timestamp utime) {
		this.utime = utime;
	}

	public Rightcontrol getRightcontrol() {
		return rightcontrol;
	}

	public void setRightcontrol(Rightcontrol rightcontrol) {
		this.rightcontrol = rightcontrol;
	}

	public List<Site> getSites() {
		return sites;
	}

	public void setSites(List<Site> sites) {
		this.sites = sites;
	}

	public Datum getDatum() {
		return datum;
	}

	public void setDatum(Datum datum) {
		this.datum = datum;
	}
}
