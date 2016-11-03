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
	private String tid;
	private String teacher;
	
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
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	/**
	 * log for toString method
	 */
	@Override
	public String toString() {
		return "SubjectVO [subjectCode=" + subjectCode + ", subjectName=" + subjectName + ", tid=" + tid + "]";
	}
}