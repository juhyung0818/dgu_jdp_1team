<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/sHeader.jsp"%>


<div align="center">
	<div class="box-header with-border">
		<h3 class="box-title">EXAM LIST</h3>
	</div>

	<table class="w3-table w3-bordered">
			<tr>
				<th>EXAM NAME</th>
				<th>START TIME</th>
				<th>END TIME</th>
				<th>SCORE</th>
			</tr>
			<c:forEach items="${list}" var="scoreExamVO" varStatus="i" >
				<tr>
					<td>${scoreExamVO.examName}</td>
					<td>${scoreExamVO.startTime}</td>
					<td>${scoreExamVO.endTime}</td>
					<td>
						<script type = "text/javascript">
							if("${scoreExamVO.score}" == -1){
								document.write("<div class='box-footer' >" +
					                     "<a href='/question/try?subjectCode=${scoreExamVO.subjectCode}&examName=${scoreExamVO.examName}'>" +
		                        "<button class='w3-btn w3-white w3-border w3-border-pink w3-round-xlarge'> TRY </button>" +
		                     "</a> </div>");
							} else{
								document.write("${scoreExamVO.score}");
							}
          				</script>
					</td>
				</tr>
			</c:forEach>
		</table>
		<button type="submit" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge btn-danger">SUBJECT REMOVE</button>
		<br><br>
</div>

<script>
$(document).ready(function() {

	var formObj = $("form[role='form']");

	console.log(formObj);

	$(".btn-danger").on("click", function() {
		formObj.attr("action", "/subject/leave");
		formObj.submit();
	});

});
</script>

<%@include file="../include/sFooter.jsp"%>