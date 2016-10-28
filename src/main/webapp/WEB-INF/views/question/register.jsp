<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
	<%@include file="../include/header.jsp"%>
	

	
<body>
	<font size="7" color="black"> 문제 출제 </font> 
	<br> <br>

	<form fole="form" method="post">

<!-- 	<div class="box-body">
		<div class="form-group">
			<p> 과목코드
			<input type="int" name="subjectCode" class="form-contorl" placeholder="Enter subjectCode" border-color="pink">
			 </p>
		</div>

		<div class="form-group">
			<p> 시험이름
			<textarea class="form-control" name="examName" rows="1" placeholder="Enter ..."></textarea>
			</p>
		</div> -->
		
	
	<c:forEach var="i" begin="0" varStatus="status" end="0">
		<table border="3" bordercolor="hotpink">
		<tr><td>
		<form fole="form" method="post">
			<div class="form-group">
				<input type="int" name="qNumber" class="form" placeholder="Enter qNumber" value='${i+1}' >
				<label for="exampleInputEmail1"> 번 문제</label>
			</div>

			<div class="form-group">
				<p> 문제입력 <br>
				<textarea class="form-control" name="qInfo" rows="10" placeholder="Enter ..."></textarea>
				</p>
			</div>
		
			<div class="form-group">
				<p> 1번
				<textarea class="form-control" name="ex1" rows="1" placeholder="Enter ..."></textarea>
				</p>
			</div>
		
			<div class="form-group">
				<p> 2번
				<textarea class="form-control" name="ex2" rows="1" placeholder="Enter ..."></textarea>
				</p>
			</div>
		
			<div class="form-group">
				<p> 3번
				<textarea class="form-control" name="ex3" rows="1" placeholder="Enter ..."></textarea>
				</p>
			</div>
		
			<div class="form-group">
				<p> 4번
				<textarea class="form-control" name="ex4" rows="1" placeholder="Enter ..."></textarea>
				</p>
			</div>

			<div class="form-group">
				<p> 배점
				<input type="int" name="qPoint" class="form-contorl" placeholder="Enter qPoint">
				</p>
			</div>
				<p> 정답
   				<input type="radio" name="example" value="1"> 1번 
   				<input type="radio" name="example" value="2"> 2번 
   				<input type="radio" name="example" value="3"> 3번
   				<input type="radio" name="example" value="4"> 4번 
				</p>
			</div>
		</form>
		</td></tr>
		</table>
	</c:forEach>
	
		<div class="box-footer">
			<input type="submit" value="등록">
    		<input type="reset" value="취소">
		</div>

	</form>
</body>