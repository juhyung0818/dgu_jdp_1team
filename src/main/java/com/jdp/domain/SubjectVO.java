package com.jdp.domain;

/**
 * Value Object
 * class about Subject
 * @author YJH
 * 2016.11.01.Thu
 */
public class SubjectVO {

	private int subjectCode;
	private String subjectName;
	private String uid;
	
	/* setter, getter methods */
	public int getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(int subjectCode) {
		this.subjectCode = subjectCode;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	/**
	 * toString for log
	 */
	@Override
	public String toString() {
		return "SubjectVO [subjectCode=" + subjectCode + ", subjectName=" + subjectName + "]";
	}
}
