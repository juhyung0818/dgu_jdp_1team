<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script>
var result = '${code}';

if(result == 'NOT_SUBJECT'){
	alert("접근할 수 없는 과목입니다.");
	history.back();
}

if(result == 'ALREADY_TOOK_EXAM'){
	alert("이미 시험에 응시하셨습니다.");
	history.back();
}

if(result == 'TIME_OUT'){
	alert("시험 시간이 아닙니다.");
	history.back();
}
</script>