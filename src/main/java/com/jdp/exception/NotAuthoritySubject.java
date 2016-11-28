package com.jdp.exception;

/**
 * user have not authority to access a subject
 * @author kwon
 * 2016.11.20.Sun
 */
public class NotAuthoritySubject extends ExamException{

	@Override
	public ExceptionCode getExceptionCode() {
		return ExceptionCode.NOT_SUBJECT;
	}
}