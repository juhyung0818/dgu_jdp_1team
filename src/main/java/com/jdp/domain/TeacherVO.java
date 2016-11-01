package com.jdp.domain;
/**
 * Value Object
 * class about Teacher
 * @author YJH
 * 2016.10.30.Sun
 */
public class TeacherVO {

	private String tid;
	private String pw;
	private String name;
	
	/* setter, getter methods */
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "TeacherVO [tid=" + tid + ", pw=" + pw + ", name=" + name + "]";
	}
}
