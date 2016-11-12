<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/tHeader.jsp"%>

<div style="text-align:center">
	<div class="box-header with-border">
		<h3 class="box-title">SUBJECT LIST</h3>
	</div>
<div style="max-width: 80%">

	<form class="form-inline" role="form" method="post">
		<table class="w3-table w3-bordered">
			<tr>
				<th>SUBJECT NAME</th>
				<th>ENTER</th>
			</tr>
			<c:forEach items="${list}" var="subjectVO">
				<tr>
					<td>${subjectVO.subjectName}</td>
					<td>
						<div class="box-footer" >
							<a href='/exam/managementExam?subjectCode=${subjectVO.subjectCode}'> 
							<input type="button" value="ENTER"
							 class="w3-btn w3-white w3-border w3-border-red w3-round-xlarge w3-hover-text-red"></a>
							<a class="w3-btn w3-white w3-border w3-border-red w3-round-xlarge w3-hover-text-red"
							 href="/score/management?subjectCode=${subjectVO.subjectCode}&subjectName=${subjectVO.subjectName}">Management</a>
							<a class="w3-btn w3-white w3-border w3-border-red w3-round-xlarge w3-hover-text-red" 
							 href="/subject/tDelete?subjectCode=${subjectVO.subjectCode}">Delete</a>
						</div>
					</td>
				</tr>
			</c:forEach>
		</table>
		<div class="box-footer" align="right">
			<a href='/subject/tRegister'>
				<input type="button" class="w3-btn w3-pink" value="ADD">
			</a>
		</div>
		<br><br>
	</form>
</div>
</div>

<%@include file="../include/sFooter.jsp"%>