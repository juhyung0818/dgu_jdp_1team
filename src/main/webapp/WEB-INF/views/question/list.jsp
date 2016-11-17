<%@include file="../include/tHeader.jsp"%>
<head>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script>
		var questionArray = new Array();
		var questionInfo = new Object();
		
	</script>
</head>
<style type="text/css">
#box1 {
	width: 225px;
	height: 225px;
	background-image: url("c:\User\Desktop\admin\teachr.jpg")
}

.tg {
	border-collapse: collapse;
	border-spacing: 0;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
}

.tg .tg-i46p {
	background-color: pink;
	color: pink
}

.tg .tg-yw4l {
	vertical-align: top
}
</style>
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


						<c:forEach items="${list}" var="questionVO" varStatus="i">
							<table class="tg">
								<tr>



									<td>Q${questionVO.qNumber}.</td>



									<td>point��: ${questionVO.qPoint}</td>


									<th class="th-yw4l" colspan="9" rowspan="2">
										<div>
											<p>Answer</p>
											<label class="w3-validate">GIVE UP</label> <input
												type="radio" name="answer${i.count}" value="0" checked>
											<label class="w3-validate">1) </label> <input
												class="w3-radio" type="radio" name="answer${i.count}"
												value="1"> <label class="w3-validate">2) </label> <input
												class="w3-radio" type="radio" name="answer${i.count}"
												value="2"> <label class="w3-validate">3) </label> <input
												class="w3-radio" type="radio" name="answer${i.count}"
												value="3"> <label class="w3-validate">4) </label> <input
												class="w3-radio" type="radio" name="answer${i.count}"
												value="4">
										</div>
									</th>
								</tr>
								<tr>
								</tr>
								<tr>
									<td class="th-yw4l" colspan="15" rowspan="8"><textarea
											class="form-control" readonly cols="100" rows="20">${questionVO.qInfo}</textarea>
									</td>
								</tr>
								<tr>
								</tr>
								<tr>
								</tr>
								<tr>
								</tr>
								<tr>
								</tr>
								<tr>
								</tr>
								<tr>
								</tr>
								<tr>
								</tr>
								<tr>

									<td class="tg-yw4l" colspan="15" rowspan="5">
										<p></p>
										<ul class="w3-ul w3-border">
											<li>1) ${questionVO.ex1}</li>
											<li>2) ${questionVO.ex2}</li>
											<li>3) ${questionVO.ex3}</li>
											<li>4) ${questionVO.ex4}</li>
										</ul>
									</td>
								</tr>
							</table>
						</c:forEach>

					</div>
					<br>
					<br>
					<div class="box-footer">
						<br>
						<button id="complete"
							class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge"
							value="10">COMPLETE</button>
						<button type="reset"
							class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge"
							onclick="exam/studentExam?subjectCode=${subjectCode}">
							CANCLE</button>


						<c:forEach items="${list}" var="questionVO" varStatus="i">
							<table class="tg">
							    <tr>
								<td>Q${questionVO.qNumber}.</td>
								<td> <input type="number" value='${questionVO.qPoint}' /></td>
								<th class="th-yw4l" colspan="9" rowspan="2">
								    <div> 
									    <p>Answer</p>
									    <script type="text/javascript">
											var head = "<label class='w3-validate'>";
											var body = ") </label> <input class='w3-radio' type='radio' name='answer${i.count}' value=";
											var tail = ">";
											var checked = " checked>";
									    	for(var i=1; i<=4; i++){
									    		document.write(head + i + body + i);
									    		if('${questionVO.answer}' == i){
									    			document.write(checked);
									    		}else {
									    			document.write(tail);
									    		}
									    	}
									    
									    </script>
									</div>
								</th>
								</tr>
									<tr>
									</tr>
									<tr>
									<td class="th-yw4l" colspan="15" rowspan="8">
									<textarea class="form-control" cols="100" rows="20">${questionVO.qInfo}</textarea>
								    </td>
							</tr>
							 <tr>
                            </tr>
                            <tr>
  							</tr>
  							<tr>
  							</tr>
  							<tr>
  							</tr>
  							<tr>
  							</tr>
  							<tr>
  							</tr>
  							<tr>
  							</tr>
  							<tr>
								<td class="tg-yw4l" colspan="15" rowspan="5">
								<p></p>
									<ul class="w3-ul w3-border">
									<li>1)
										<div class="form-group">
											<input class="w3-input" name="ex1${status.count}" rows="1"
												placeholder="Enter ..." value='${questionVO.ex1}'>
										</div>
									</li>
									<li>2)
										<div class="form-group">
											<input class="w3-input" name="ex2${status.count}" rows="1"
												placeholder="Enter ..." value='${questionVO.ex2}'>
										</div>
									</li>
									<li>3)
										<div class="form-group">
											<input class="w3-input" name="ex3${status.count}" rows="1"
												placeholder="Enter ..."  value='${questionVO.ex3}'>
										</div>
									</li>
									<li>4)
										<div class="form-group">
											<input class="w3-input" name="ex4${status.count}" rows="1"
												placeholder="Enter ..." value='${questionVO.ex4}'>
										</div>
									</li>
									</ul></td>
							</tr>
							</table>
						</c:forEach>
					
				</div>
				<br><br>
					<div class="box-footer"> <br>
						<button id="modify" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge" value="10"> MODIFY </button>
						<button type="reset" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge"
						onclick="exam/studentExam?subjectCode=${subjectCode}"> CANCLE </button>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<script>
$("#modify").click( function(){
	var question = [];
	var i;
	for (i = 1; i <= '${num}' ; i++) {
		question.push($('input[name=qNumber'+ i +']').val());
		question.push($('input[name=qPoint'+ i +']').val());
		question.push($('input[name=answer'+ i +']:checked').val());
		question.push($('#qInfo'+i).val());
		question.push($('input[name=ex1'+ i +']').val());
		question.push($('input[name=ex2'+ i +']').val());
		question.push($('input[name=ex3'+ i +']').val());
		question.push($('input[name=ex4'+ i +']').val());
	} 
	console.log(question);
	$.ajax({
		type : 'POST',
		data:({'question': question})
	});
});
</script>

<%@include file="../include/tFooter.jsp"%>