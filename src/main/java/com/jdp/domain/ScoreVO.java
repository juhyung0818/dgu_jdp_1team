package com.jdp.domain;

/**
 * Value Object
 * class about Score
 * @author YJH
 * 2016.11.06.Sun
 */

public class ScoreVO {

	private int examCode;
	private String examName;
	private String uid;
	private int score;
	
	//getter, setter. toString methods
	public int getExamCode() {
		return examCode;
	}
	public void setExamCode(int examCode) {
		this.examCode = examCode;
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
	@Override
	public String toString() {
		return "ScoreVO [examCode=" + examCode + ", examName=" + examName + ", uid=" + uid + ", score=" + score + "]";
	}

}