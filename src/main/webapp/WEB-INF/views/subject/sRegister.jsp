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
				<input type="text" class="w3-input w3-border w3-round-large" name="subjectCode" placeholder="Write subject code" />
			</div>
			<div class="form-group">
				<label for="subjectCode">GRADE</label>
				<input type="text" class="w3-input w3-border w3-round-large" name="grade" placeholder="Write grade" />
			</div>
			<div class="form-group">
				<label for="subjectCode">CLASS NUMBER</label>
				<input type="text" class="w3-input w3-border w3-round-large" name="classNumber" placeholder="Write class number" />
			</div>
			<div class="form-group">
				<label for="subjectCode">STUDENT NUMBER</label>
				<input type="text" class="w3-input w3-border w3-round-large" name="studentNumber" placeholder="Write student number" />
			</div>
		</div>
		<div class="box-footer"><br>
			<button type="submit"  class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge"> ADD </button>
			<button type="reset" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge"> CANCLE </button>
		</div>
		</fieldset>
	</form>
	</center>
</body>
</html>
<%@include file="../include/sFooter.jsp"%>