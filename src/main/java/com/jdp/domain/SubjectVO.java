package com.jdp.domain;

public class SubjectVO {
	private int subjectCode;
	private String subjectName;
	private int tid;

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
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	
	@Override
	public String toString() {
		return "SubjectVO [subjectCode=" + subjectCode + ", subjectName=" + subjectName + ", tid=" + tid + "]";
	}
}
