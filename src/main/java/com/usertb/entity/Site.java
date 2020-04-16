package com.usertb.entity;

import org.apache.ibatis.annotations.Insert;

/**
 * 收货地址表
 */
public class Site {
	private Integer id;
	private Integer uid;// user id
	private Integer mailbox;// 地区邮编
	private String address;// 收货地址
	private String phone;// 电话
	private String name;// 姓名

	public Site(){}

	public Site(Integer id, Integer uid, Integer mailbox, String address, String phone, String name) {
		this.id = id;
		this.uid = uid;
		this.mailbox = mailbox;
		this.address = address;
		this.phone = phone;
		this.name = name;
	}

	public Site(Integer id, Integer mailbox, String address, String phone, String name) {
		this.id = id;
		this.mailbox = mailbox;
		this.address = address;
		this.phone = phone;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Site{" +
				"id=" + id +
				", uid=" + uid +
				", mailbox=" + mailbox +
				", address='" + address + '\'' +
				", phone='" + phone + '\'' +
				", name='" + name + '\'' +
				'}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getMailbox() {
		return mailbox;
	}

	public void setMailbox(Integer mailbox) {
		this.mailbox = mailbox;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
}
