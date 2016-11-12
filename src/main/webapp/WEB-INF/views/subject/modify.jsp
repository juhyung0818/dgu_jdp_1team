<%@include file="../include/tHeader.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<body>
	<center>
	<h1>
		Subject Modify
	</h1>
	<form class="form-inline" role="form" method="post" action="modify">
		<input type='hidden' name='subjectCode' value="${subjectCode}"> 
		<fieldset>
			<div class="box-footer"><br>
				<input type="text" class="w3-input w3-border w3-round-large" name="subjectName" value ="${subjectName}"/>
			</div>
		</fieldset>
	</form>
	
		<div class="box-footer"><br>
			<button type="submit"  class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge btn-primary"> SAVE </button>
			<button type="submit" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge btn-warning"> CANCEL </button> 
		</div>
	</center>
</body>

<script>
$(document).ready(
	function() {

		var formObj = $("form[role='form']");

		console.log(formObj);
		
		$(".btn-primary")
			.on("click",function() {
			formObj.submit();
		});
		
		$(".btn-warning")
			.on("click",function() {
			self.location = "/subject/tSubject";
		});
	});
</script>

<%@include file="../include/tFooter.jsp"%>