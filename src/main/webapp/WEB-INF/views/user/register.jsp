<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/tHeader.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<head>
<style type="text/css">
label {
	display: none;
}

input {
	height: 30px;
}

fieldset {
	width: 200pt;
	border: 3;
	border-color: pink;
}
</style>
</head>
<body>
	<center>
		<h1>User Register</h1>
			<fieldset>
				<form action="/user/register" methoe="post">
					<table>
						<tr>
							<th>ID: </th>
							<td><input type="text" name="uid"><br></td>
						</tr>
						<tr>
							<th>PW: </th>
							<td><input type="text" name="upw"><br></td>
						</tr>
						<tr>
							<th>Name: </th>
							<td><input type="text" name="uname"><br></td>
						</tr>
						<tr>
							<th>직업: </th>
							<td>
								<input type="radio" name="gender" value="1" > 선생님
  								<input type="radio" name="gender" value="0"> 학생
							</td>
						</tr>
					</table>
					<input type="submit" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge" value="OK">
					<a href='/'>
						<input type="button" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge" value="BACK">
					</a>
				</form>
			</fieldset>
	</center>
</body>
</html>

<%@include file="../include/tFooter.jsp"%>

