<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/tHeader.jsp"%>

<div align="center">
	<div class="box-header with-border">
		<h3 class="box-title">EXAM LIST</h3>
	</div>

	<table class="w3-table w3-bordered">
		<tr>
			<th>EXAM NAME</th>
			<th>START TIME</th>
			<th>END TIME</th>
			<th>MODIFY</th>
		</tr>
		<c:forEach items="${list}" var="examVO">
			<tr>
				<td>${examVO.examName}</td>
				<td>${examVO.startTime}</td>
				<td>${examVO.endTime}</td>
				<td>
					<a href='/question/modify?subjectCode=${examVO.subjectCode}&examName=${examVO.examName}'>
						<button id="modify" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge"> MODIFY </button>
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
	</div>
</div>



<%@include file="../include/tFooter.jsp"%>