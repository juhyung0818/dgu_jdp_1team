<%@include file="../include/tHeader.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>register exam</title>

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
		Subject Register
	</h1>
	<form class="form-inline" role="form" method="post">
	<fieldset>
		<div class="box-footer"><br>
				<label for="subjectName">subject name</label>
				<input type="text" class="w3-input w3-border w3-round-large" name="subjectName" placeholder="Write subject name" />
			</div>
		</div>
		<div class="box-footer"><br>
			<button type="submit"  class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge"> submit </button>
			<button type="reset" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge"> cancel </button>
		</div>
		</fieldset>
	</form>
	</center>
</body>
</html>
<%@include file="../include/tFooter.jsp"%>
