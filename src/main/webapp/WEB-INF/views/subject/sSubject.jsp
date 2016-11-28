<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/sHeader.jsp"%>

<div align=center style="max-width: 1500px">
	<div class="box-header with-border">
		<h3 class="box-title">SUBJECT LIST</h3>
	</div>
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
						<div class="box-footer">
							<a href='/exam/studentExam?subjectCode=${subjectVO.subjectCode}'>
								<input type="button" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge" value="ENTER">
							</a>
						</div>
					</td>
				</tr>
			</c:forEach>
		</table>
		<div class="box-footer" align="right">
			<a href='/subject/sRegister'> <input type="button"
				class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge" value="ADD">
			</a>
		</div>
		<br>
		<br>
	</form>
</div>

<%@include file="../include/sFooter.jsp"%>