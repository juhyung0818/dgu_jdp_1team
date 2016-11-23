package com.jdp.exception;

public class NotAuthoritySubject extends ExamException{

	@Override
	public ExceptionCode getExceptionCode() {
		return ExceptionCode.NOT_SUBJECT;
	}

}
