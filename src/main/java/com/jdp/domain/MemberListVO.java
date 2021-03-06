package com.jdp.domain;

import java.util.List;

/**
 * Value Object
 * class about Member
 * @author YJH
 * 2016.11.06.Sun
 */
public class MemberListVO {

	private String uid;
	private int subjectCode;
	private int grade;
	private int classNumber;
	private int studentNumber;
	private String uname;
	private List<ScoreVO> scoreList;
	private double average;
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
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public List<ScoreVO> getScoreList() {
		return scoreList;
	}
	public void setScoreList(List<ScoreVO> scoreList) {
		this.scoreList = scoreList;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	/* toString for log */
	@Override
	public String toString() {
		return "MemberVO [uid=" + uid + ", subjectCode=" + subjectCode + ", grade=" + grade + ", classNumber="
				+ classNumber + ", studentNumber=" + studentNumber + ", uname=" + uname+ "]";
	}
}
