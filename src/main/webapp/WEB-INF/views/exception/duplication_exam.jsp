<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script>
var result = '${code}';

if(result == 'DUPLICATE_EXAM'){
	alert("이미 존재하는 시험입니다.");
	self.location = "/subject/tSubject";
}

</script>