<%@include file="../include/tHeader.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>

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
	<fieldset>
		<div class="box-body"><br>
		<form class="form-inline" role="form" method="post">
		<input type='hidden' name='subjectCode' value="${subjectCode}"/>
		<input type='hidden' name='examCode' value="${examCode}"/>
			<div class="box-body">
				<div class="form-group">
					<label for="examName">exam name</label>
					<input type="text" name="examName" class="w3-input w3-border w3-round-large" value="${examName}">
				</div>
				<div class="form-group">
					<label for="startTime">start time</label>
					<input type="text" name="startTime" class='datetimepicker' value="${startTime}">
			
				</div>
				<div class="form-group">
					<label for="endTime">end time</label>
					<input type="text" name="endTime" class='datetimepicker' value="${endTime}">
				</div>
			</div>
			<button type="submit"  class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge btn-primary"> SAVE </button>
			<a href='/exam/managementExam?subjectCode=${subjectCode}'>
				<button id="cancel" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge"> CANCEL </button>
			</a> 
		</form>
		</div>
	</fieldset>
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
		
	});
</script>
<%@include file="../include/tFooter.jsp"%>