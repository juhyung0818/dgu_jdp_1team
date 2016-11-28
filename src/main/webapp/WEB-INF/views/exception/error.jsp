<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script>
var result = '${code}';

	if(result == 'NOT_EXIST_SUBJECT'){
		alert("존재하지 않는 과목입니다.");
		history.back();
	}
	if(result == "PRIMARY_KEY_DUPLICATE"){
		alert("이미 존재합니다.");
		history.back();
	}
	if(result == "DUPLICATE_SUBJECT"){
		alert("이미 존재하는 과목입니다.");
		history.back();
	}
	if(result == "DUPLICATE_EXAM"){
		alert("이미 존재하는 시험입니다.");
		history.back();
	}
	if(result == "INVALID_TYPE"){
		alert("유효하지 않은 입력입니다.");
		history.back();
	}
	if(result == "NOT_EXIST"){
		alert("존재하지 않습니다.");
		history.back();
	}
	if(result == "NOT_EXIST_SUBJECT_NAME"){
		alert("과목의 이름을 입력해 주세요.");
		history.back();
	}
	if(result == "NOT_EXIST_EXAM_NAME"){
		alert("시험의 이름을 입력해 주세요.");
		history.back();
	}
	if(result == "NOT_EXIST_SUBJECT"){
		alert("존재하지 않는 과목입니다.");
		history.back();
	}
	if(result == "NOT_EXIST_EXAM"){
		alert("존재하지 않는 시험입니다.");
		history.back();
	}
	if(result == "ACCESS_DENIED"){
		alert("접근 권한이 없습니다.");
		history.back();
	}
	if(result == "NOT_SUBJECT"){
		alert("접근권한이 없는 과목입니다.");
		history.back();
	}
	if(result == "NOT_EXAM"){
		alert("접근권한이 없는 시험입니다.");
		history.back();
	}
	if(result == "TIME_OUT"){
		alert("시험시간이 아닙니다.");
		history.back();
	}
	if(result == "ALREADY_TOOK_EXAM"){
		alert("이미 응시한 시험입니다.");
		history.back();
	}
</script>	
