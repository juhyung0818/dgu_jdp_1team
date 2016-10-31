<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>register exam</title>
	<link rel="stylesheet" href="//mugifly.github.io/jquery-simple-datetimepicker/jquery.simple-dtpicker.css">
	<script src="//code.jquery.com/jquery.min.js"></script>
	<script src="//mugifly.github.io/jquery-simple-datetimepicker/jquery.simple-dtpicker.js"></script>
	<script>
		$(function(){
  		$('.datetimepicker').appendDtpicker({'locale':'ko'});
		});
	</script>        
	
	<style type="text/css">
		label {
			display : none;
		}	
		input {
			height : 30px;
		}
		button{
			width : 150px;
			height : 30px;
		}
		fieldset{
			width : 200px;
		}
	</style>
</head>
<body>
	<form class="form-inline" role="form" method="post">
	<fieldset>
	<center>
<<<<<<< HEAD
		<div class="box-body">
			<div class="form-group">
				<label class=".hidden" for="subjectCode" >subject code</label>
				<input type="text" class="form-control" id="subjectCode" placeholder="subject code">
			</div>
			<div class="form-group">
				<label for="examName">exam name</label>
				<input type="text" id="examName" placeholder="exam name">
			</div>
			<div class="form-group">
				<label for="totalScore">total score</label>
				<input type="number" id="totalScore" placeholder= "total score">
			</div>
			<div class="form-group">
				<label for="startTime">start time</label>
				<input type="text" id="startTime" class='datetimepicker' value="">
			</div>
			<div class="form-group">
				<label for="endTime">end time</label>
				<input type="text" id="endTime" class='datetimepicker' value="">
			</div>
		</div>
		<div class="box-footer">
			<button type="submit" class="btn">submit</button>
		</div>
	</center>
	</fieldset>
=======
	<font size="7" color="hotpink"> 문제 출제 </font> 
	<hr color="hotpink"> 
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
		
	
	<c:forEach var="i" begin="0" varStatus="status" end="1">
		<table border="3" bordercolor="hotpink">
		<tr><td>
		<form fole="form" method="post">
	
			<div class="box-body">
				<div class="form-group">
					<input type="int" name="qNumber" class="form" placeholder="Enter qNumber" value=@i>
					<label for="exampleInputEmail1"> 번 </label>
				</div>

			<div class="form-group">
				<p> 문제입력 <br>
				<textarea class="form-control" name="qInfo" rows="10" placeholder="Enter ..."></textarea>
				</p>
			</div>
		
			<div class="box-body">
				<div class="form-group">
					<p> 1번
					<textarea class="form-control" name="ex1" rows="1" placeholder="Enter ..."></textarea>
					</p>
				</div>
		
			<div class="box-body">
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

>>>>>>> 4a2c114d442107589a45d8d65a181898215bca09
	</form>
</body>
</html>