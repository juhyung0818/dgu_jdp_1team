<%@include file="../include/sHeader.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title></title>
<link rel="stylesheet"
	href="//mugifly.github.io/jquery-simple-datetimepicker/jquery.simple-dtpicker.css">
<script src="//code.jquery.com/jquery.min.js"></script>
<script
	src="//mugifly.github.io/jquery-simple-datetimepicker/jquery.simple-dtpicker.js"></script>
<script>
	$(function() {
		$('.datetimepicker').appendDtpicker({
			'locale' : 'ko'
		});
	});
</script>

<style type="text/css">
label {
	display: none;
}

input {
	height: 30px;
}

fieldset {
	width: 200pt;
	border: 3;
	border-color: pink;
}
</style>
</head>
<body>
	<center>
	<h1>
		Subject Register
	</h1>
	<form class="form-inline" method="post">
	<fieldset>
		<div class="box-body">
			<div class="form-group">
				<label for="subjectCode">SUBJECT CODE</label>
				<input type="number" class="w3-input w3-border w3-round-large" name="subjectCode" placeholder="Write subject code" required />
			</div>
			<div class="form-group">
				<label for="grade">GRADE</label>
				<input type="text" class="w3-input w3-border w3-round-large" name="grade" placeholder="Write grade" required/>
			</div>
			<div class="form-group">
				<label for="classNumber">CLASS NUMBER</label>
				<input type="text" class="w3-input w3-border w3-round-large" name="classNumber" placeholder="Write class number" required/>
			</div>
			<div class="form-group">
				<label for="studentNumber">STUDENT NUMBER</label>
				<input type="text" class="w3-input w3-border w3-round-large" name="studentNumber" placeholder="Write student number" required/>
			</div>
		</div>
		<div class="box-footer"><br>
			<input type="submit"  class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge" value="ADD"> 
			<a href='/subject/sSubject'>
				<input type="button" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge" value="BACK">
			</a>
		</div>
		</fieldset>
	</form>
	</center>
</body>
</html>
<%@include file="../include/sFooter.jsp"%>