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
			<c:forEach items="${list}" var="examVO">
				<tr>
					<td>${examVO.examName}</td>
					<td>${examVO.startTime}</td>
					<td>${examVO.endTime}</td>
					<td>${score}</td>
					<td>
						<div class="box-footer" >
							<a href='/question/try?subjectCode=${examVO.subjectCode}&examName=${examVO.examName}'> <input
								type="button" class="w3-btn w3-pink" value="TRY">
							</a>
						</div>
					</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<br>
	</form>
</div>


<!-- <script>
//buttons 
$(document).ready(function(){
	var formObj = $("form[role='form']");
	console.log(formObj);
	
	$(".w3-btn w3-pink").on("click", function(){
		formObj.attr("action", "/exam/register");
		formObj.attr("method", "get");		
		formObj.submit();
	});
});

</script> -->

<%@include file="../include/sFooter.jsp"%>