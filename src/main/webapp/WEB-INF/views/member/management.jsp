<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/tHeader.jsp"%>

<div style="text-align: center">
	<div class="box-header with-border">
		<h3 class="box-title">MEMBER LIST</h3>
	</div>

		<table class="w3-table w3-bordered">
			<tr>
				<th>GRADE</th>
				<th>CLASS NUMBER</th>
				<th>STUDENT NUMBER</th>
				<th>NAME</th>
				<th>STATUS</th>
			</tr>
			<c:forEach items="${member}" var="memberVO">
				<tr>
					<td>
						${memberVO.grade}
					</td>
					
					<td>
						${memberVO.classNumber}
					</td>
					
					<td>
						${memberVO.studentNumber}
					</td>
					
					<td>
						${memberVO.uname}(${memberVO.uid})
					</td>
					
					<td>
						<c:choose>
							<c:when test="${memberVO.flag==0 }">
								<form action="/member/register?subjectCode=${memberVO.subjectCode }&uid=${memberVO.uid}" method="post">
									<button class="w3-btn w3-white w3-border w3-border-red w3-round-xlarge w3-hover-text-red" id="register">REGISTER</button>
									
									<script type="text/javascript">
										$("#register").click( function(){
											 if(confirm("등록 하시겠습니까?"))
												 alert("등록 되었습니다.");
											 else
											 {
												 alert("취소했습니다.");
												 return false;
											 }
										
										});
									</script>
									
								</form>	
							</c:when>
							
							<c:when test="${memberVO.flag==1 }">
								<form action="/member/remove?subjectCode=${memberVO.subjectCode }&uid=${memberVO.uid}" method="post">
									<button class="w3-btn w3-white w3-border w3-border-red w3-round-xlarge w3-hover-text-red" id="kick">REMOVE</button>
									<script type="text/javascript">
										$("#kick").click( function(){
											 if(confirm("탈퇴 시키겠습니까?"))
												 alert("탈퇴 되었습니다.");
											 else
											 {
												 alert("취소했습니다.");
												 return false;
											 }
										
										});
									</script>
								</form>	
							</c:when>
						</c:choose>
					</td>
					
				</tr>
			</c:forEach>
		</table>
		
		<br>
		<br>
</div>

<script>


	
	
</script>

<%@include file="../include/sFooter.jsp"%>