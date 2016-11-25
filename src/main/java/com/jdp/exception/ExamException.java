package com.jdp.exception;

/**
 * exception class
 * @author YJH
 * 2016.11.20.Sun
 */
public abstract class ExamException extends RuntimeException{
	private static final long serialVersionUID = 8570300479191506240L;

	public abstract ExceptionCode getExceptionCode();
}
