package com.jdp.domain;

import java.util.List;

public class QuestionListVO {

	private List<QuestionVO> qList;
	
	public List<QuestionVO> getqList() {
		return qList;
	}

	public void setqList(List<QuestionVO> qList) {
		this.qList = qList;
	}

	@Override
	public String toString() {
		return "QuestionListVO [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	} 
}
