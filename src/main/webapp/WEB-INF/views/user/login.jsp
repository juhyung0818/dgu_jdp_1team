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
.member {
	font-size: 50px;
	text-shadow: 0 0 10px #666;
	color: #fff;
	margin: 0 auto;
	text-align: center;
	text-transform: capitalize;
	font-family: Arial, sans-serif font-style : italic;
}

body {
	font-family: Arial, sans-serif font-size : 12px;
}

.form {
	width: 450px;
	height: 280px;
	border-radius: 25px;
	border: 5px double #999;
	margin: 30px auto;
}

.form2 {
	width: 450px;
	min-width: 320px;
	height: 200px;
	margin: 60px auto;
	margin-left: 20px;
}

.form3 {
	float: left;
	/*   background:#f00;  */
}

.form3 label {
	width: 100px;
	height: 20px;
	/*  display: block; */
	float: left;
}

.form4 {
	padding: 0px 0px 0px 70px;
}

#wrap {
	width: 600px;
	height: 500px;
	margin: 0 auto;
}

.clear {
	clear: both;
}

input[type="submit"] {
	float: left;
	/*  display:block; */
	height: 50px;
	background: #FFBB00;
	border-radius: 5px;
	border: none;
	font-family: Arial, sans-serif
}

input[type="button"] {
	height: 30px;
	background: gray;
	border-radius: 5px;
	/*  width: 140px; */
	font-family: Arial, sans-serif margin-top : 10px;
	margin-left: 100px;
	margin-right: 20px;
}

input[type="checkbox"] {
	margin-top: 20px;
}

.contentsimg {
	width: 300px;
	height: 150;
}
</style>

<body>


	<!-- !PAGE CONTENT! -->
	<div class="w3-content" style="max-width: 1500px">

		<!-- Header -->
		<header class="w3-panel w3-center w3-opacity">
			<div class="w3-panel w3-pink">
				<h1 class="w3-opacity">순성닷컴</h1>
			</div>
		</header>

	</div>

	<form action="/user/loginPost" method="post">
		<div id="my-form">
			<div id="wrap">
				<h1 class="member">member login</h1>
				<img class='contentsimg' src="/resources/teacher.jpg">
				<div class="form">
					<div class="form2">
						<div class="form3">
							<label for="user">아이디</label><input type="text" id="uid"
								name="uid">
							<div class="clear"></div>
							<label for="user">비밀번호</label><input type="password" name="upw">
						</div>
						<input type="submit" value="로그인하기">
						<div class="clear"></div>
						<div class="form4">
							<label><input type="checkbox" name="useCookie">아이디저장</label>
							<div class="clear"></div>
							<a class="w3-btn w3-pink" href="/user/register">회원가입</a>

						</div>
					</div>
				</div>
			</div>

		</div>



	</form>


</body>

</html>

