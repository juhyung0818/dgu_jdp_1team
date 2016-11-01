package com.jdp.domain;

/**
 * Value Object
 * class about Student
 * @author YJH
 * 2016.10.24.Mon
 */
public class StudentVO {

	private String sid;
	private String pw;
	
	/* setter, getter methods */
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	@Override
	public String toString() {
		return "StudentVO [sid=" + sid + ", pw=" + pw + "]";
	}
}
