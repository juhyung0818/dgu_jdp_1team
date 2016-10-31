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
				
				<th>SUBJECT CODE</th><td>${subjectCode}</td>
						
				<table class="w3-table w3-bordered">
					<tr>
						<th>EXAM NAME</th>
						<th>START TIME</th>
						<th>END TIME</th>
					</tr>
					<c:forEach items="${list}" var="examVO">
						<tr>
							<td><a href='/teacher/read?subjectCode=${examVO.subjectCode}&examName=${examVO.examName}'>
								${examVO.examName} </a></td>
							<td>${examVO.startTime}</td>
							<td>${examVO.endTime}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		<!-- Main content -->

<%@include file="../include/tFooter.jsp"%>


