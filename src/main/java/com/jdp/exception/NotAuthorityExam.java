package com.jdp.exception;

public class NotAuthorityExam extends NotAuthoriedException{

	@Override
	public ExceptionCode getExceptionCode() {
		return ExceptionCode.NOT_EXAM;
	}

}
