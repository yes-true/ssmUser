package com.usertb.entity;

/**
 * 接收前端信息
 */
public class Param {
	private User user;
	private Datum datum;
	private Rightcontrol rightcontrol;
	private Site site;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Datum getDatum() {
		return datum;
	}

	public void setDatum(Datum datum) {
		this.datum = datum;
	}

	public Rightcontrol getRightcontrol() {
		return rightcontrol;
	}

	public void setRightcontrol(Rightcontrol rightcontrol) {
		this.rightcontrol = rightcontrol;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}
}
