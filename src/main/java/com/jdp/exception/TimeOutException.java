package com.jdp.exception;
/**
 * user have not authority to accesing exam
 * @author kwon
 * 2016.11.20.Sun
 */
public class TimeOutException extends NotAccessException {

	@Override
	public ExceptionCode getExceptionCode() {
		return ExceptionCode.TIME_OUT;
	}
}