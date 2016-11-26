<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/sHeader.jsp"%>

<script>
	var b = ${examActive};
	if(!b)
		self.window.alert("not time to take a exam!!!");
</script>

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
					<td id="score${i.count}">
						<script type = "text/javascript">
							if("${scoreExamVO.score}" == -1){
								document.write(
										"<form id='msg' action='/exam/studentExamPost?examCode=${scoreExamVO.examCode}' method='post'>" +
					                	"<input type='hidden' name='subjectCode' value='${subjectCode}''>" +
		                        		"<div class='box-footer' >" +
		                     				"<button id ='tryBtn' class='w3-btn w3-white w3-border w3-border-pink w3-round-xlarge' onclick='isTry(${scoreExamVO.score})'> TRY </button>"+
		                        		"</div>"+
		                        	"</form>"
		                     		);
							} else{
								document.write("${scoreExamVO.score}");
							}
						</script>
					</td>
				</tr>
			</c:forEach>
		</table>
		<form action="/subject/leave?subjectCode=${subjectCode}" method="post">
			<button type="submit" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge btn-danger">SUBJECT REMOVE</button>
		</form>
		<br><br>
</div>

<script>

 function isTry(score)
 {
  	if(score!=-1)
  		alert('you took a exam before!!!');

 }
 
 </script>

<%@include file="../include/sFooter.jsp"%>