<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<html>
<head>
<title>순성닷컴</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">

<style>
body, h1{
	font-family : "Raleway", Arial, sans-serif
}

h1 {
	letter-spacing: 10px
}

.w3-row-padding img {
	margin-bottom: 12px
}

.w3-row-padding {
	margin-bottom: 128px
}

.w3-myfont {
	font-family: "Comic Sans MS", cursive, sans-serif;
}

</style>

<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.1.1.min.js"> </script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>

</head>
<body>
	
	<!-- !PAGE CONTENT! -->
	<div class="w3-content" style="max-width: 80%">
		<div style="text-align:right">
			${uname}님 환영합니다.
			<a class="w3-btn w3-pink" href="/user/logout">logout</a>
		</div>
		<!-- Header -->
		<header class="w3-panel w3-center w3-opacity">
			<div class="w3-panel w3-pink">
				<h1 >순성닷컴 </h1>
				
			</div>

			<div class="w3-xxxlarge">
				<p class="w3-myfont">성적 관리</p>
			</div>
			<br>
			<a class="w3-btn w3-white w3-border w3-border-red w3-round-xlarge w3-hover-text-red"

				href="/subject/tSubject">과목 관리</a> 

		</header>
	</div>
<div align="center">
	<div class="box-header with-border">

	</div>
	<form class="form-inline" role="form" method="post" >
		<table class="w3-table w3-bordered">
			<tr>
				<th><input type="text" name="member_grade" placeholder="학년"></th>
				<th><input type="text" name="member_classNumber" placeholder="반"></th>
				<th><input type="text" name="member_studentNumber" placeholder="학번"></th>
				<th><input type="text" name="member_uname" placeholder="이름"></th>
				<th><button type="submit" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge"> 검색 </button></th>
			<tr>
				<th>학년</th>
				<th>반</th>
				<th>번호</th>
				<th>이름</th>
				<c:forEach items="${listExam}" var="examVO">
				<th>${examVO.examName}</th>
				</c:forEach>
				<th>학생의 평균<th>	
			</tr>
			<c:forEach items="${list}" var="memberListVO">
				<tr>
					<td>${memberListVO.grade}</td>
					<td>${memberListVO.classNumber}</td>
					<td>${memberListVO.studentNumber}</td>
					<td>${memberListVO.uname}</td>
					<c:forEach items="${memberListVO.scoreList}" var="scoreVO">
						<td>
						<script type ="text/javascript">
							if("${scoreVO.score}"==0){
								document.write("-");
							}else{
								document.write("${scoreVO.score}");
							}
						</script>
						</td>
					</c:forEach>
					<td>${memberListVO.average}<td>	
				</tr>
			</c:forEach>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td>검색 평균</td>
				<c:forEach items="${averageVO}" var="averageVO">
						<td>${averageVO.someAvg}</td>
				</c:forEach>
			<tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td>전체 수강생 평균</td>
				<c:forEach items="${averageVO}" var="averageVO">
						<td>${averageVO.allAvg}</td>
				</c:forEach>
			<tr>
		</table>
		<br><br>
	</form>
</div>


<%@include file="../include/sFooter.jsp"%>