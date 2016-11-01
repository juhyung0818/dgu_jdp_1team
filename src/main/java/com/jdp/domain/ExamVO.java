package com.jdp.domain;

import java.sql.Timestamp;


/**
 * Value Object
 * class about Exam
 * @author YJH
 * 2016.10.19.Wed
 */
public class ExamVO {

	private int subjectCode;
	private String examName;
	private int studentCnt;
	private int questionNum;
	private Timestamp startTime;
	private Timestamp endTime;
	
	/* setter, getter methods */
	public int getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(int subjectCode) {
		this.subjectCode = subjectCode;
	}
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	
	public int getStudentCnt() {
		return studentCnt;
	}
	public void setStudentCnt(int studentCnt) {
		this.studentCnt = studentCnt;
	}
	public int getQuestionNum() {
		return questionNum;
	}
	public void setQuestionNum(int questionNum) {
		this.questionNum = questionNum;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	public Timestamp getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	@Override
	public String toString() {
		return "ExamVO [subjectCode=" + subjectCode + ", examName=" + examName + ", studentCnt=" + studentCnt
				+ ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
}