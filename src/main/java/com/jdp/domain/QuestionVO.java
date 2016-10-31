package com.jdp.domain;
/**
 * Value Object of Question
 * @author YJH
 * 2016.10.19.Wed
 */
public class QuestionVO {
	
	int subjectCode;
	String examName;
	int qNumber;
	String qInfo;
	int qPoint;
	int answer;
	
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
		return "QuestionVO [examName=" + examName + ", qNumber=" + qNumber + ", qInfo=" + qInfo + ", qPoint=" + qPoint
				+ ", answer=" + answer + "]";
	}
}