package com.jdp.exception;
/**
 * user have not authority to accesing exam
 * @author kwon
 * 2016.11.20.Sun
 */
public class NotAuthorityExam extends NotAuthoriedException{

	@Override
	public ExceptionCode getExceptionCode() {
		return ExceptionCode.NOT_EXAM;
	}

}
