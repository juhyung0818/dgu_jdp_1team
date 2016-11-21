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
				<p class="w3-myfont">${subjectName}</p>
			</div>
			<br>
			<a class="w3-btn w3-white w3-border w3-border-red w3-round-xlarge w3-hover-text-red"

				href="/subject/tSubject">과목 관리</a> 
			<!-- <a sclass="w3-btn w3-white w3-border w3-border-red w3-round-xlarge w3-hover-text-red"
				href="/subject/studentSubject">성적관리</a>-->
				
		</header>
	</div>