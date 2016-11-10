package com.jdp.domain;

public class UserVO {
	private String uid;
	private String upw;
	private String uname;
	private int flag;
	
	/* getter, setter methods */
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int uflag) {
		this.flag = uflag;
	}
	@Override
	public String toString() {
		return "UserVO [uid=" + uid + ", upw=" + upw + ", uname=" + uname + ", flag=" + flag + "]";
	}
	
}
