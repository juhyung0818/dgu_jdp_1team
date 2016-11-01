<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/tHeader.jsp"%>
				
		<!-- Main content -->
				
			<div align="center">
				<div class="box-header with-border">
					<h3 class="box-title">EXAM LIST</h3>
				</div>
				
						
				<table class="w3-table w3-bordered">
					<tr>
						<th>EXAM NAME</th>
						<th>START TIME</th>
						<th>END TIME</th>
					</tr>
					<c:forEach items="${list}" var="examVO">
						<tr>
							<td><a href='/question/list?subjectCode=${examVO.subjectCode}&examName=${examVO.examName}'>
								${examVO.examName} </a></td>
							<td>${examVO.startTime}</td>
							<td>${examVO.endTime}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		<!-- Main content -->
		
		<br><br>
		<div class="box-footer" align="right">
			<input type="button" class="w3-btn w3-pink" value="ADD" onClick="self.location='/exam/register';">
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

<%@include file="../include/tFooter.jsp"%>