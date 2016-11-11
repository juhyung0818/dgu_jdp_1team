package com.jdp.domain;

import java.sql.Timestamp;

/**
 * Value Object of score and exam
 * @author YJH
 * 2016.11.11.Fri
 */
public class ScoreExamVO {

	private int subjectCode;
	private String examName;
	private Timestamp startTime;
	private Timestamp endTime;
	private int score;
	
	//getter, setter methods
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
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	//toString method for log
	@Override
	public String toString() {
		return "ScoreExamVO [subjectCode=" + subjectCode + ", examName=" + examName + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", score=" + score + "]";
	}
	
}
