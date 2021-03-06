package com.jdp.dto;
/**
 * 
 * @author LYJ
 * 2016.11.27.SUN
 */
public class MemberDTO {
	private String uid;
	private int subjectCode;
	private int grade;
	private int classNumber;
	private int studentNumber;
	private String studentName;
	
	/* getter, setter methods */
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public int getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(int subjectCode) {
		this.subjectCode = subjectCode;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getClassNumber() {
		return classNumber;
	}
	public void setClassNumber(int classNumber) {
		this.classNumber = classNumber;
	}
	public int getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	/* toString for log */
	@Override
	public String toString() {
		return "MemberVO [uid=" + uid + ", subjectCode=" + subjectCode + ", grade=" + grade + ", classNumber="
				+ classNumber + ", studentNumber=" + studentNumber + ", studentName=" + studentName + "]";
	}
}
