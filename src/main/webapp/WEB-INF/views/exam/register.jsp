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
		
		fieldset{
			width : 200px;
		}
	</style>
</head>
<body>
	<form class="form-inline" role="form" method="post">
	<fieldset>
	<center>
		<div class="box-body">
			<div class="form-group">
				<label class=".hidden" for="subjectCode" >subject code</label>
				<input type="text" class="form-control" name="subjectCode" placeholder="subject code">
			</div>
			<div class="form-group">
				<label for="examName">exam name</label>
				<input type="text" name="examName" placeholder="exam name">
			</div>
			<div class="form-group">
				<label for="questionNum">question number</label>
				<input type="number" name="questionNum" placeholder="number of question">
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
			<button type="reset" class="btn">cancel</button>
		</div>
	</center>
	</fieldset>

	</form>
</body>
</html>