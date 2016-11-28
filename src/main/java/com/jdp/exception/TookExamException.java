package com.jdp.exception;

public class TookExamException extends ExamException{

	@Override
	public ExceptionCode getExceptionCode() {
		return ExceptionCode.ALREADY_TOOK_EXAM;
	}
}