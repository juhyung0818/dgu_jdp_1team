<%@include file="../include/sHeader.jsp"%>

<section class="content">
	<div align="center">
	<div class="row">
		<div class="col-md-12">
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title"></h3>
				</div>
				<div align="center">
					<div class="box-header with-border">
						<h3 class="box-title">QUESTIONS</h3>
					</div>
					<table class="w3-striped w3-bordered">

						<c:forEach items="${list}" var="questionVO" varStatus="i">
							<tr>
								<td>Q${questionVO.qNumber}.</td>
								<td>point: ${questionVO.qPoint}</td>
								<td> 
									<label class="w3-validate">GIVE UP</label>
									<input type="radio" name="answer${i.count}" value="0" checked>
									<label class="w3-validate">1) </label>
									<input class="w3-radio" type="radio" name="answer${i.count}" value="1">
									<label class="w3-validate">2) </label> 
									<input class="w3-radio" type="radio" name="answer${i.count}" value="2"> 
									<label class="w3-validate">3) </label>
									<input class="w3-radio" type="radio" name="answer${i.count}" value="3">
									<label class="w3-validate">4) </label>
									<input class="w3-radio" type="radio" name="answer${i.count}" value="4">
								</td>
							</tr>
							<tr>
								<td colspan="3">${questionVO.qInfo}<br> <br>
									EXAMPLES
									<ul class="w3-ul w3-border">
										<li>1) ${questionVO.ex1}</li>
										<li>2) ${questionVO.ex2}</li>
										<li>3) ${questionVO.ex3}</li>
										<li>4) ${questionVO.ex4}</li>
									</ul></td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<br><br>
					<div class="box-footer"> <br>
						<button id="complete" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge" value="10"> COMPLETE </button>
						<button type="reset" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge"
						onclick="exam/studentExam?subjectCode=${subjectCode}"> CANCLE </button>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<script>
$("#complete").click( function(){
	
		var answer = [];
		var i;
		for (i = 1; i < '${size}' ; i++) {
			answer.push($('input[name=answer'+ i +']:checked').val());
		}
		console.log(answer);
		$.ajaxSettings.traditional = true;
		$.ajax({
			type : 'POST',
			url : '/question/try?subjectCode=${subjectCode}&examName=${examName}',
			headers: {
				"Contnet-Type": "application/json;charset=UTF-8",
				"X-HTTP-Method-Override": "POST" 
				},
				data: ({'answer': answer})
		});
		self.location = "/exam/studentExam?subjectCode="+${subjectCode};
});
</script>

<%@include file="../include/sFooter.jsp"%>