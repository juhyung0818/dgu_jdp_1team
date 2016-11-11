<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/sHeader.jsp"%>


<div align="center">
	<div class="box-header with-border">
		<h3 class="box-title">EXAM LIST</h3>
	</div>


	<form class="form-inline" role="form" method="post">
		<table class="w3-table w3-bordered">
			<tr>
				<th>EXAM NAME</th>
				<th>START TIME</th>
				<th>END TIME</th>
				<th>SCORE</th>
				<th>TRY</th>
			</tr>
			<c:forEach items="${list}" var="scoreExamVO">
				<tr>
					<td>${scoreExamVO.examName}</td>
					<td>${scoreExamVO.startTime}</td>
					<td>${scoreExamVO.endTime}</td>
					<td>${scoreExamVO.score}</td>
					<td>
						<div class="box-footer" >
							<button id="try" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge"
							 value ="${examVO.examName}"> TRY </button>
						</div>
					</td>
				</tr>
			</c:forEach>
		</table>
		<br><br>
	</form>
</div>

<script>
$("#try").click( function(){
	if('${isTry}' == '${uid}'){
		console.log("true");
		$(function(){
			alert("You can't do it!");
		});
	}else{
		var examName = [];
		examName.push($("#try").val());
		console.log("false");
		$.ajax({
			type : 'POST',
			url : '/exam/studentExam?subjectCode=${subjectCode}&examName=$("#try").val()',
			data:({'examName': $("#try").val()})
		});
	}
 });
</script>

<%@include file="../include/sFooter.jsp"%>