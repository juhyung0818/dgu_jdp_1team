<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/sHeader.jsp"%>
				<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>student main</title>
	<link rel="stylesheet" href="//mugifly.github.io/jquery-simple-datetimepicker/jquery.simple-dtpicker.css">
	<script src="//code.jquery.com/jquery.min.js"></script>
	<script src="//mugifly.github.io/jquery-simple-datetimepicker/jquery.simple-dtpicker.js"></script>
	
	<style type="text/css">
	
		fieldset{
			width : 200pt;
			border : 3;
			border-color : pink;
		}
		button{
			text-align : center;
		}
	</style>
</head>
		<!-- Main content -->
				
			<div align="center">
			
				"${login.uid} "
				<input type="text" name="studentID" value='${login.uid }' readonly>
			
				<div class="box-header with-border">
					<h3 class="box-title">SUBJECT LIST</h3>
				</div>
				
				<th>SUBJECT CODE</th><td>${subjectCode}</td>
				
				<fieldset>
				<table class="w3-table w3-bordered">
					<tr>
						<th>SUBJECT NAME</th>
					</tr>
					<c:forEach items="${list}" var="subjectVO">
						<tr>
							<td>
							<!-- <a href='/teacher/read?subjectCode=${examVO.subjectCode}&examName=${examVO.examName}'> -->
								${subjectVO.subjectName} </a></td>
						</tr>
					</c:forEach>
				</table>
				</fieldset>
				<div class="box-footer" align="right">
				
				<!-- <input type="button" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge" value="refresh" onClick="self.location='/student/studentMain';"> -->
			</div>
			</div>
		<!-- Main content -->
		
		<br><br>
		<center>		
			<button type="submit" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge"  onClick="self.location='/subject/register';">add</button>
				<button type="submit" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge"  onClick="self.location='/subject/register';">refresh</button>
		</center>
		
<!-- 		
<script>
//buttons 
$(document).ready(function(){
	var formObj = $("form[role='form']");
	console.log(formObj);
	
	$(".w3-btn w3-pink").on("click", function(){
		formObj.attr("action", "/teacher/register");
		formObj.attr("method", "get");		
		formObj.submit();
	});
});

</script>
 -->
<%@include file="../include/tFooter.jsp"%>