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
					<a href='/exam/modify?examCode=${examVO.examCode}'>
						<button id="modify" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge"> MODIFY </button>
					</a>
				</td>
				<td>
					<a href='/question/modify?examCode=${examVO.examCode}'>
						<button id="enter" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge"> ENTER </button>
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<br><br>
	<div class="box-footer" align="right">
		<form action="/subject/tDelete?subjectCode=${subjectCode}" method="post">
		
		<a href='/exam/register?subjectCode=${subjectCode}'>
			<input type="button" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge" value="ADD">
		</a>
		<a href="/subject/modify?subjectCode=${subjectCode}">
			<input type="button" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge" value="SUBJECT MODIFY">
		</a>
		
			<button type="submit" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge">SUBJECT REMOVE</button>
		
		<a href="/subject/tSubject">
			<input type="button" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge" value="CANCEL">		
		</a>
		</form>
	</div>
</div>

<%@include file="../include/tFooter.jsp"%>