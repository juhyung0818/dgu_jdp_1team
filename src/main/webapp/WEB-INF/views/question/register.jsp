<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@include file="../include/tHeader.jsp"%>
<head>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	<script>
		var questionArray = new Array();
		var questionInfo = new Object();
		
	</script>
</head>

<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}
		.tg .tg-i46p{background-color:pink;color:pink}
		.tg .tg-yw4l{vertical-align:top}
</style>

<form role="form" action="modify" method="post">
	<input type='hidden' name='examCode' value="${examCode}"> 
</form>

<body>
	<div align="center">
		<font size="7" color="black"> 문제 출제 </font> <br> <br>

			<c:forEach var="i" begin="1" varStatus="status" end='${num}'>
				<table class="tg ">
					<tr>
						<th class="tg-i46p" colspan="3" rowspan="2">
							<div class="form-group">
								Q<input class="w3-input" type="number" name="qNumber${status.count}" placeholder="Enter qNumber" value='${i}' readonly>
								<!-- 
									<label for="exampleInputEmail1"></label>
						 		-->
							</div>
						</th>
						<th class="th-yw4l" colspan="3" rowspan="2">
							<div class="form-group">
								<p>배점</p><input type="number" name="qPoint${status.count}" class="form-contorl" placeholder="Enter qPoint" value="0">
							</div>
						</th>
						<th class="th-yw4l" colspan="9" rowspan="2">
							<div>
									<p>정답</p>
										<label class="w3-validate">1)</label>
										<input class="w3-radio" type="radio" name="answer${status.count}" value="1" checked> 
										<label class="w3-validate">2)</label>
										<input class="w3-radio" type="radio" name="answer${status.count}" value="2">
										<label class="w3-validate">3)</label>
										<input class="w3-radio" type="radio" name="answer${status.count}" value="3">
										<label class="w3-validate">4)</label>
										<input class="w3-radio" type="radio" name="answer${status.count}" value="4">
									
						</div>
						</th>
						</tr>
						<tr>

						</tr>
						<tr>
						<td class="tg-yw4l" colspan="15" rowspan="8">
						  <textarea class="form-control" name="qInfo${status.count}" id="qInfo${status.count}" cols="100" rows="20"
										placeholder="Enter ..."></textarea>
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
  						<td class="tg-yw4l" colspan="15" rowspan="5"><p>보기</p>	
  									<ul class="w3-ul w3-border">

									<li>1)
										<div class="form-group">
											<input class="w3-input" name="ex1${status.count}" rows="1"
												placeholder="Enter ...">
										</div>
									</li>
									<li>2)
										<div class="form-group">
											<input class="w3-input" name="ex2${status.count}" rows="1"
												placeholder="Enter ...">
										</div>
									</li>
									<li>3)
										<div class="form-group">
											<input class="w3-input" name="ex3${status.count}" rows="1"
												placeholder="Enter ..." >
										</div>
									</li>
									<li>4)
										<div class="form-group">
											<input class="w3-input" name="ex4${status.count}" rows="1"
												placeholder="Enter ...">
										</div>
									</li>
								</ul></td>
							</tr>
							<tr>
   							</tr>
    						<tr>
     						</tr>
     						<tr>
    						</tr>
     						<tr>
     						</tr>
   				 </table>
				<p></p>	
				</c:forEach>

				<div class="box-footer"> <br>
					<button id="complete" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge"> COMPLETE </button>
					<a href='/exam/managementExam?subjectCode=${subjectCode}'>
						<button id="cancel" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge"> CANCEL </button>
					</a>
				</div>

			</div>
</body>

<script>
$("#complete").click( function(){
	var question = [];

	var i;
	for (i = 1; i <= '${num}' ; i++) {
		question.push("qNumber : " + $('input[name=qNumber'+ i +']').val());
		question.push("qPoint : " $('input[name=qPoint'+ i +']').val());
		question.push("answer : " $('input[name=answer'+ i +']:checked').val());
		question.push("qInfo : " $('#qInfo'+i).val());
		question.push("ex1 : " $('input[name=ex1'+ i +']').val());
		question.push("ex2 : " $('input[name=ex2'+ i +']').val());
		question.push("ex3 : " $('input[name=ex3'+ i +']').val());
		question.push("ex4 : " $('input[name=ex4'+ i +']').val());
		
	} 
	console.log(question);
	$.ajax({
		type : 'POST',
		url : '/question/register?examCode=${examCode}',
		headers: {
			"Contnet-Type": "text/plain; charset=UTF-8",
			"X-HTTP-Method-Override": "POST" 
			},
			data:JSON.stringify({question: question})
	});
	self.location = "/exam/managementExam?subjectCode="+${subjectCode};
	//reload before page
	//opener.location.reload();
});
</script>	
	
<%@include file="../include/tFooter.jsp"%>