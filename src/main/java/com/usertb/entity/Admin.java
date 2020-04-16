package com.usertb.entity;

import java.util.Date;

/**
 * 管理员
 */
public class Admin {
	//
	private Integer id;
	// 邮箱
	private String email;
	// 电话
	private String phone;
	// 密码
	private String passWord;
	// 插入时间
	private Date atime;
	// 修改时间
	private Date utime;
	// 权限表
	private Rightcontrol rightcontrol;

	public Admin() {}

	public Admin(Integer id, String email, String phone, String passWord, Date atime, Date utime) {
		this.id = id;
		this.email = email;
		this.phone = phone;
		this.passWord = passWord;
		this.atime = atime;
		this.utime = utime;
	}

	@Override
	public String toString() {
		return "Admin{" +
				"id=" + id +
				", email='" + email + '\'' +
				", phone='" + phone + '\'' +
				", passWord='" + passWord + '\'' +
				", atime=" + atime +
				", utime=" + utime +
				", rightcontrol=" + rightcontrol +
				'}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public Date getAtime() {
		return atime;
	}

	public void setAtime(Date atime) {
		this.atime = atime;
	}

	public Date getUtime() {
		return utime;
	}

	public void setUtime(Date utime) {
		this.utime = utime;
	}

	public Rightcontrol getRightcontrol() {
		return rightcontrol;
	}

	public void setRightcontrol(Rightcontrol rightcontrol) {
		this.rightcontrol = rightcontrol;
	}
}
