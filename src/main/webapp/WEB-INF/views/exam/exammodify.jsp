<%@include file="../include/tHeader.jsp"%>
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
			width : 200pt;
			border : 3;
			border-color : pink;
		}
	</style>
</head>
<body>
	<center>
	<h1>
		Exam modify
	</h1>
	<form class="form-inline" role="form" method="post">
	<input type='hidden' name='subjectCode' value="${subjectCode}">
	<fieldset>
		<div class="box-body">
			<div class="form-group">
				<label for="examName">exam name</label>
				<input type="text" class="w3-input w3-border w3-round-large" name="examName" value="${examName}">
			</div>
		<div class="form-group">
				<label for="startTime">start time</label>
				<input type="text" id="startTime" class='datetimepicker' value="${startTime}">
				
			</div>
			<div class="form-group">
				<label for="endTime">end time</label>
				<input type="text" id="endTime" class='datetimepicker' value="${endTime}">
				
			</div>
		</div>
		<div class="box-footer"><br>
			<button type="submit" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge"> submit </button>
			<button type="reset" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge"> cancel </button>
		</div>
		</fieldset>
	</form>
	</center>
</body>
</html>
<%@include file="../include/tFooter.jsp"%>