package com.jdp.domain;
/**
 * Value Object of Question
 * @author YJH
 * 2016.10.19.Wed
 */
public class QuestionVO {
	
	private int subjectCode;
	private String examName;
	private int qNumber;
	private String qInfo;
	private String ex1;
	private String ex2;
	private String ex3;
	private String ex4;
	private int qPoint;
	private int answer;

	public QuestionVO() {
		subjectCode = 200;
		examName = "test";
	}
	
	/**
	 * subjectCode getter method
	 * @return code of subject
	 */
	public int getSubjectCode() {
		return subjectCode;
	}
	/**
	 * subject setter method
	 * @param subjectCode
	 */
	public void setSubjectCode(int subjectCode) {
		this.subjectCode = subjectCode;
	}
	/**
	 * examName getter method
	 * @return name of exam :code of subject
	 */
	public String getExamName() {
		return examName;
	}
	/**
	 * examName setter method
	 * @param examName :name of exam
	 */
	public void setExamName(String examName) {
		this.examName = examName;
	}
	/**
	 * qNumber getter method
	 * @return number of question
	 */
	public int getqNumber() {
		return qNumber;
	}
	/**
	 * qNumber setter method
	 * @param qNumber :number of question
	 */
	public void setqNumber(int qNumber) {
		this.qNumber = qNumber;
	}
	/**
	 * qInfo getter method
	 * @return content of question 
	 */
	public String getqInfo() {
		return qInfo;
	}
	/**
	 * qInfo setter method
	 * @param qInfo :content of question
	 */
	public void setqInfo(String qInfo) {
		this.qInfo = qInfo;
	}
	public String getEx1() {
		return ex1;
	}
	public void setEx1(String ex1) {
		this.ex1 = ex1;
	}
	public String getEx2() {
		return ex2;
	}
	public void setEx2(String ex2) {
		this.ex2 = ex2;
	}
	public String getEx3() {
		return ex3;
	}
	public void setEx3(String ex3) {
		this.ex3 = ex3;
	}
	public String getEx4() {
		return ex4;
	}
	public void setEx4(String ex4) {
		this.ex4 = ex4;
	}

	/**
	 * qPoint getter method
	 * @return point of question
	 */
	public int getqPoint() {
		return qPoint;
	}
	/**
	 * qPoint setter method
	 * @param qPoint :point of question
	 */
	public void setqPoint(int qPoint) {
		this.qPoint = qPoint;
	}
	/**
	 * answer getter method
	 * @return answer of question
	 */
	public int getAnswer() {
		return answer;
	}
	/**
	 * answer setter method
	 * @param answer :answer of question
	 */
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	/**
	 * overrided from Object 
	 */
	@Override
	public String toString() {
		return "QuestionVO [subjectCode=" + subjectCode + ", examName=" + examName + ", qNumber=" + qNumber + ", qInfo="
				+ qInfo + ", ex1=" + ex1 + ", ex2=" + ex2 + ", ex3=" + ex3 + ", ex4=" + ex4 + ", qPoint=" + qPoint
				+ ", answer=" + answer + "]";
	}
}