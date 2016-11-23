<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/tHeader.jsp"%>

<div align="center">
	<div class="box-header with-border">

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
				<c:forEach items="${listExam}" var="examVO">
				<th>${examVO.examName}</th>
				</c:forEach>
				<th>학생의 평균<th>	
			</tr>
			<c:forEach items="${list}" var="memberListVO">
				<tr>
					<td>${memberListVO.grade}</td>
					<td>${memberListVO.classNumber}</td>
					<td>${memberListVO.studentNumber}</td>
					<td>${memberListVO.uname}</td>
					<c:forEach items="${memberListVO.scoreList}" var="scoreVO">
						<td>
						<script type ="text/javascript">
							if("${scoreVO.score}"==0){
								document.write("-");
							}else{
								document.write("${scoreVO.score}");
							}
						</script>
						</td>
					</c:forEach>
					<td>${memberListVO.average}<td>	
				</tr>
			</c:forEach>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td>검색 평균</td>
				<c:forEach items="${averageVO}" var="averageVO">
						<td>${averageVO.someAvg}</td>
				</c:forEach>
			<tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td>전체 수강생 평균</td>
				<c:forEach items="${averageVO}" var="averageVO">
						<td>${averageVO.allAvg}</td>
				</c:forEach>
			<tr>
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