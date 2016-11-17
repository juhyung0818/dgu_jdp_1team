<%@include file="../include/tHeader.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<body>
	<center>
	<h1>
		Exam Register
	</h1>
	<form class="form-inline" role="form" method="post">
	<fieldset>
		<div class="box-body">
			<div class="form-group">
				<label for="examName">exam name</label>
				<input type="text" class="w3-input w3-border w3-round-large" name="examName" placeholder="exam name">
			</div>
			<div class="form-group">
				<label for="questionNum">question number</label>
				<input type="number" class="w3-input w3-border w3-round-large" name="num" placeholder="number of question"><br>
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
		<div class="box-footer"><br>
			<button type="submit" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge"> submit </button>
			<button type="reset" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge"> cancel </button>
		</div>
		</fieldset>
	</form>
	</center>
</body>

<%@include file="../include/tFooter.jsp"%>