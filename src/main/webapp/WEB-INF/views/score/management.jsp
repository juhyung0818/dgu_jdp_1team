<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/sHeader.jsp"%>

<div align="center">
	<div class="box-header with-border">
		<h3 class="box-title">SUBJECT LIST</h3>
	</div>


	<form class="form-inline" role="form" method="post" >
		<table class="w3-table w3-bordered">
			<tr>
				<th><input type="text" name="member_grade" placeholder="학년"></th>
				<th><input type="text" name="member_classNumber" placeholder="반"></th>
				<th><input type="text" name="member_studentNumber" placeholder="학번"></th>
				<th><input type="text" name="member_uname" placeholder="이름"></th>
				<th><button type="submit" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge"> 검색 </button></th>
			<tr>
				<th>학년</th>
				<th>반</th>
				<th>번호</th>
				<th>이름</th>
			</tr>
			<c:forEach items="${list}" var="memberListVO">
				<tr>
					<td>${memberListVO.grade}</td>
					<td>${memberListVO.classNumber}</td>
					<td>${memberListVO.studentNumber}</td>
					<td>${memberListVO.uname}</td>
				</tr>
			</c:forEach>
		</table>
		<br><br>
	</form>
</div>
<script>
	var mem_grade=$("#member_grade").val();
	function search(){
		alert(mem_grade);
	}
</script>

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