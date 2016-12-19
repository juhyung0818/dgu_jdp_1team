package com.jdp.exception;

/**
 * exception define enum class
 * @author YUN
 * 2016.11.20.Sun
 */
public enum ExceptionCode {

	//exception enums
	NONE(200, "success"),
		NONE_ID(210, "success"),
	PRIMARY_KEY_DUPLICATE(100, "primary key duplicated"),
		DUPLICATE_SUBJECT(110, "duplicated subject"),
		DUPLICATE_EXAM(120, "duplicated exam"),
		DUPLICATE_ID(130, "duplicated id"),
	INVALID_TYPE(300, "invalid type"),
	NOT_EXIST(400, "not exist"), 
		NOT_EXIST_SUBJECT_NAME(411, "subject name not exist"),
		NOT_EXIST_EXAM_NAME(412, "exam name not exist"),
		NOT_EXIST_SUBJECT(421, "subject is not exist"),
		NOT_EXIST_EXAM(422, "exam is not exist"),
	ACCESS_DENIED(500, "you don't have permission."), 
		NOT_SUBJECT(510, "not access subject"),
		NOT_EXAM(520, "not access exam"),
	TIME_OUT(600, "time out a exam"),
	ALREADY_TOOK_EXAM(700, "alreay took exam");
	
	//fields
	private int code;
	private String message;
	
	//constructor
	ExceptionCode(int code, String message){
		this.code = code;
		this.message = message;
	}

	/* getter, setter methods */
	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
