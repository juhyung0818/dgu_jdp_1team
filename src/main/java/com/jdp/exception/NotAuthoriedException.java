package com.jdp.exception;

/**
 * Accesing user have not authority
 * @author kwon
 * 2016.11.20.Sun
 */
public class NotAuthoriedException extends ExamException{

	@Override
	public ExceptionCode getExceptionCode() {
		return ExceptionCode.ACCESS_DENIED;
	}
}