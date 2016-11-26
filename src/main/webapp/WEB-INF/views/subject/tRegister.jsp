<%@include file="../include/tHeader.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

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
	<center>
		<h1>Subject Register</h1>
			<fieldset>
				<form class="form-inline" role="form" method="post">
				<div class="box-footer"> <br>
					<label for="subjectName">subject name</label> <input
					type="text" class="w3-input w3-border w3-round-large"
					name="subjectName" placeholder="Write subject name" />
				</div>
					<br>
					<input type="submit" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge" value="OK">
					<a href='/subject/tSubject'>
						<input type="button" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge" value="BACK">
					</a>
				</form>
			</fieldset>
	</center>

<script>
	var result = '${msg}';
	
	if(result == 'success'){
		alert("success");
	}

</script>

<%@include file="../include/tFooter.jsp"%>
