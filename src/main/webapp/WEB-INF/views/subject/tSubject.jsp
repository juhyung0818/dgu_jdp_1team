<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/tHeader.jsp"%>

<div style="text-align: center">
	<div class="box-header with-border">
		<h3 class="box-title">SUBJECT LIST</h3>
	</div>

		<table class="w3-table w3-bordered">
			<tr>
				<th>SUBJECT NAME</th>
				<th>ENTER</th>
				<th>REMOVE</th>
				<th>GRADE</th>
			</tr>
			<c:forEach items="${list}" var="subjectVO">
				<tr>
					<td>${subjectVO.subjectName}(${subjectVO.subjectCode})</td>
					<td>
							<a href='/exam/managementExam?subjectCode=${subjectVO.subjectCode}'> 
							<input type="button" value="ENTER"
							 class="w3-btn w3-white w3-border w3-border-red w3-round-xlarge w3-hover-text-red"></a>
					</td>
					<td>
							 <form action="/subject/tDelete?subjectCode=${subjectVO.subjectCode}" method="post">
							 	<button type="submit" class="w3-btn w3-white w3-border w3-border-red w3-round-xlarge w3-hover-text-red">REMOVE</button>
							</form>
					</td>
					<td>
						<a class="w3-btn w3-white w3-border w3-border-red w3-round-xlarge w3-hover-text-red"
						href="/score/management?subjectCode=${subjectVO.subjectCode}&subjectName=${subjectVO.subjectName}">GRADE</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<div class="box-footer" align="right">
			<a href='/subject/tRegister'>
			<input type="button" class="w3-btn w3-pink" value="ADD">
			</a>
		</div>
		<br>
		<br>
</div>

<%@include file="../include/sFooter.jsp"%>