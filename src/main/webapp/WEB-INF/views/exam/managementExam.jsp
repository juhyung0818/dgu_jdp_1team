<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/tHeader.jsp"%>

<form role="form" action="modify" method="post">
	<input type='hidden' name='subjectCode' value="${subjectCode}"> 
</form>

<div align="center">
	<div class="box-header with-border">
		<h3 class="box-title">EXAM LIST</h3>
	</div>

	<table class="w3-table w3-bordered">
		<tr>
			<th>EXAM NAME</th>
			<th>START TIME</th>
			<th>END TIME</th>
			<th>EXAM MODIFY</th>
			<th>QUESTION ENTER</th>
		</tr>
		<c:forEach items="${list}" var="examVO">
			<tr>
				<td>${examVO.examName}</td>
				<td>${examVO.startTime}</td>
				<td>${examVO.endTime}</td>
				<td>
					<a href='/exam/modify?subjectCode=${examVO.subjectCode}&examName=${examVO.examName}'>
						<button id="modify" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge"> MODIFY </button>
					</a>

				</td>
				<td>
					<a href='/question/modify?subjectCode=${examVO.subjectCode}&examName=${examVO.examName}'>
						<button id="enter" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge"> ENTER </button>
					</a>
				</td>

			</tr>
		</c:forEach>
	</table>
	
	<br><br>
	<div class="box-footer" align="right">
		
		<a href='/exam/register?subjectCode=${subjectCode}'>
			<input type="button" class="w3-btn w3-pink" value="ADD">
		</a>
		<button type="submit" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge btn-warning">SUBJECT MODIFY</button>
		<button type="submit" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge btn-danger">SUBJECT REMOVE</button>
		<a href="/subject/tSubject">
			<button id="backPage" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge"> 
				CANCEL
		 	</button> 
		</a>
	</div>
</div>

<script>
$(document).ready(function() {

	var formObj = $("form[role='form']");

	console.log(formObj);

	$(".btn-danger").on("click", function() {
		formObj.attr("action", "/subject/tDelete");
		formObj.submit();
	});
	
	$(".btn-warning").on("click", function() {
		formObj.attr("action", "/subject/modify?subjectCode=${subjectCode}");
		formObj.attr("method", "get");
		formObj.submit();
	});

});
</script>
<%@include file="../include/tFooter.jsp"%>