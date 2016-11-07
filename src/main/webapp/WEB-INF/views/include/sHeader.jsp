<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<title>순성닷컴</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
<style>
body, h1 {
	font-family: "Raleway", Arial, sans-serif
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
<body>

	<!-- !PAGE CONTENT! -->
	<div class="w3-content" style="max-width: 1500px">

		<!-- Header -->
		<header class="w3-panel w3-center w3-opacity">
			<div class="w3-panel w3-pink">
				<h1>순성닷컴 </h1>
				${uname}님 환영합니다.
			</div>
			<br>
			<!-- 이 태그는 왜 있는 거지? 과목선택이 뭐하는 거? -->
			<a class="w3-btn w3-white w3-border w3-border-red w3-round-xlarge"
				href="/subject/sSubject">과목 선택</a>
			
		</header>
