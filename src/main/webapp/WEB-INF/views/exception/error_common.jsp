<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

 <html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	
	<body>
		<h4>${exception.getMessage()}</h4>
		
		<h1> 존재하지 않는 페이지...</h1>
	</body>
	
	
	
</html>	

<!-- <script>
var result = '${code}';

if(result == 'DUPLICATE_EXAM'){
	alert("이미 존재하는 시험입니다.");
	history.back();
}

if(result == 'DUPLICATE_SUBJECT'){
	alert("이미 존재하는 과목입니다.");
	history.back();
}

if(result == 'NOT_SUBJECT'){
	alert("존재하지 않는 과목입니다.");
	history.back();
}

if(result == 'NOT_EXAM'){
	alert("존재하지 않는 시험입니다.");
	history.back();
}

if(result == 'NOT_EXIST_SUBJECT_NAME'){
	alert("과목 이름을 입력하세요");
	subject_name_not_exist.jsp
}

if(result == 'PRIMARY_KEY_DUPLICATE'){
	alert("이미 등록되어 있습니다.");
	history.back();
}
</script> -->