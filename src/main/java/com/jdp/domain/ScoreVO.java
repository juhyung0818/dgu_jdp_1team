package com.jdp.domain;

/**
 * Value Object
 * class about Score
 * @author YJH
 * 2016.11.06.Sun
 */

public class ScoreVO {

	private int subjectCode;
	private String examName;
	private String uid;
	private int score;

	/* getter, setter methods */
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
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	/* toStinrg for log*/
	@Override
	public String toString() {
		return "ScoreVO [subjectCode=" + subjectCode + ", examName=" + examName + ", uid=" + uid + ", score=" + score
				+ "]";
	}
}