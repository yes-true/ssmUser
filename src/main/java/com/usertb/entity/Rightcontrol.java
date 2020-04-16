package com.usertb.entity;

/**
 * 权限表
 */
public class Rightcontrol {
	private Integer jurisdiction;// 权限
	private Integer uid;// user id
	private Integer aid;// admin id

	public Rightcontrol(){}

	public Rightcontrol(Integer jurisdiction, Integer uid, Integer aid) {
		this.jurisdiction = jurisdiction;
		this.uid = uid;
		this.aid = aid;
	}

	@Override
	public String toString() {
		return "Rightcontrol{" +
				"jurisdiction=" + jurisdiction +
				", uid=" + uid +
				", aid=" + aid +
				'}';
	}

	public Integer getJurisdiction() {
		return jurisdiction;
	}

	public void setJurisdiction(Integer jurisdiction) {
		this.jurisdiction = jurisdiction;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}
}
