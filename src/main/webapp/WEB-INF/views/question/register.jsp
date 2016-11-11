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

<body>
	<div align="center">
		<font size="7" color="black"> 문제 출제 </font> <br> <br>
				<c:forEach var="i" begin="1" varStatus="status" end='${num}'>
					<table class="w3-striped ">
						<tr>
							<td>QPOINT</td>
							<td colspan="2">QUESTION INFOMATION</td>
							<td>ANSWER</td>
						</tr>
						<tr>
							<td>
								<ul class="w3-ul">
									<li>Q
										<div class="form-group">
											<input class="w3-input" type="number" name="qNumber${status.count}"
												placeholder="Enter qNumber" value='${i}'>
											<label for="exampleInputEmail1"></label>
										</div>
									</li>
									<li>
										<p>배점</p>
										<div class="form-group">
											<input type="number" name="qPoint${status.count}" class="form-contorl" placeholder="Enter qPoint" value="0">
										</div>
									</li>
								</ul>
							</td>
							<td>
								<p>문제입력</p>
								<div class="form-group">
									<textarea class="form-control" name="qInfo${status.count}" id="qInfo${status.count}" rows="11"
										placeholder="Enter ..." ></textarea>
								</div>
							</td>
							<td>
								EXAMPLES
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
							<td>
								<div>
									<p>
									
										정답 
										<label class="w3-validate">1)</label>
										<input class="w3-radio" type="radio" name="answer${status.count}" value="1" checked> 
										<label class="w3-validate">2)</label>
										<input class="w3-radio" type="radio" name="answer${status.count}" value="2">
										<label class="w3-validate">3)</label>
										<input class="w3-radio" type="radio" name="answer${status.count}" value="3">
										<label class="w3-validate">4)</label>
										<input class="w3-radio" type="radio" name="answer${status.count}" value="4">
									</p>
								</div>
							</td>
						</tr>
					</table>
				</c:forEach>

				<div class="box-footer"> <br>
					<button id="complete" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge"> COMPLETE </button>
					<button type="reset" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge"
					onclick="exam/studentExam?subjectCode=${subjectCode}"> CANCLE </button>
				</div>
		</div>
	
<script>
$("#complete").click( function(){
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
		url : '/question/register?subjectCode=${subjectCode}&examName=${examName}',
		data:({'question': question})
	});
});
</script>	
	
<%@include file="../include/tFooter.jsp"%>