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

ul {
    list-style-type: none;
    position : relative;
    margin: 0;
    padding: 0;
    overflow: hidden;
}

li {
    float: left;
    width : 50%;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover:not(.active){
	background-color: #111;
}
</style>

<body>

	<!-- !PAGE CONTENT! -->
	<div class="w3-content" style="max-width: 1500px">

		<!-- Header -->
		<header class="w3-panel w3-center w3-opacity">
			<div class="w3-panel w3-pink">
				<h1 >순성닷컴 </h1>
			</div>

			<div class="w3-xxxlarge">
				<p class="w3-myfont">${subjectName}</p>
			</div>
			<br>
<<<<<<< HEAD
			<ul class="w3-pink">
				<li><a href="managementExam">시험관리</a></li>
				<li><a href="managementGrade">성적관리</a></li>
			</ul>	
		</header>
=======
			<a class="w3-btn w3-white w3-border w3-border-red w3-round-xlarge"
				href="/exam/managementExam?subjectCode=${subjectCode}">시험관리</a> <a
				class="w3-btn w3-white w3-border w3-border-red w3-round-xlarge"
				href="/exam/managementGradesubjectCode=${subjectCode}">성적관리</a>
				
		</header>
	</div>
>>>>>>> 8a2de50852acdf4d132ccfa1f2146b43230603d1
