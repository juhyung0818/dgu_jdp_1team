package com.jdp.domain;
/**
 * Value Object
 * class about Check
 * qNumber qPoint answer
 * @author YJH
 * 2016.11.06.Sun
 */
public class CheckVO {

	private int qNumber;
	private int answer;
	private int qPoint;
	
	public int getqNumber() {
		return qNumber;
	}
	public void setqNumber(int qNumber) {
		this.qNumber = qNumber;
	}
	public int getAnwser() {
		return answer;
	}
	public void setAnwser(int answer) {
		this.answer = answer;
	}
	public int getqPoint() {
		return qPoint;
	}
	public void setqPoint(int qPoint) {
		this.qPoint = qPoint;
	}
	@Override
	public String toString() {
		return "CheckVO [qNumber=" + qNumber + ", answer=" + answer + ", qPoint=" + qPoint + "]";
	}
}
