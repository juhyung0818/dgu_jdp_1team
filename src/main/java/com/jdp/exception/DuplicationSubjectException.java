
package com.jdp.exception;
/**
 * When insert MySQL, subject already exists
 * @author YJH
 * 2016.11.25.Fri
 */

public class DuplicationSubjectException extends PrimaryKeyDuplicatedException{

	@Override
	public ExceptionCode getExceptionCode() {
		return ExceptionCode.DUPLICATE_SUBJECT;
	}
}
