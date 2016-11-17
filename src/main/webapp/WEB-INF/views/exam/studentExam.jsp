<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/sHeader.jsp"%>

<div align="center">
	<div class="box-header with-border">
		<h3 class="box-title">EXAM LIST</h3>
	</div>

<<<<<<< HEAD
		<table class="w3-table w3-bordered">
=======
	<table class="w3-table w3-bordered">
>>>>>>> 7e2dacd19373c40124a16a8c98dae0d313dcb72a
			<tr>
				<th>EXAM NAME</th>
				<th>START TIME</th>
				<th>END TIME</th>
				<th>SCORE</th>
				<th>TRY</th>
			</tr>
			<c:forEach items="${list}" var="scoreExamVO" varStatus="i" >
				<tr>
					<td>${scoreExamVO.examName}</td>
					<td>${scoreExamVO.startTime}</td>
					<td>${scoreExamVO.endTime}</td>
					<td id="score${i.count}">
						<script type = "text/javascript">
							if("${scoreExamVO.score}" == -1){
								document.write("-");
							} else{
								document.write("${scoreExamVO.score}");
							}
          				</script>
					</td>
					<td>
					<form role="form" method="post">
						<input type='hidden' name='subjectCode' value="${subjectCode}"> 
						<input type='hidden' name='examName' value="${scoreExamVO.examName}"> 
						<div class="box-footer" >
<<<<<<< HEAD
							<form id="msg" action="/exam/studentExamPost?subjectCode=${scoreExamVO.subjectCode}&examName=${scoreExamVO.examName}" method="post">
								<button id ="tryBtn" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge" onclick="isTry(${scoreExamVO.score})"> TRY </button>
							</form>
=======
							<button type="submit" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge btn-primary">TRY</button>
>>>>>>> 7e2dacd19373c40124a16a8c98dae0d313dcb72a
						</div>
					</form>
					</td>
				</tr>
			</c:forEach>
		</table>
		<button type="submit" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge btn-danger">SUBJECT REMOVE</button>
		<br><br>
</div>
<<<<<<< HEAD
=======

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
>>>>>>> 7e2dacd19373c40124a16a8c98dae0d313dcb72a

 <script>
 function isTry(score)
 {
  	if(score!=-1)
  		alert('you took a exam before!!!');
 }
 
 </script>
<%@include file="../include/sFooter.jsp"%>