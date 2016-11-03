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
		<form fole="form" method="post" class="w3-container">
		
<%-- 				<c:forEach var="i" begin="1" varStatus="status" end='${num}'>
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
											<input class="w3-input" type="int" name="qNumber"
												placeholder="Enter qNumber" value='${i}'>
											<label for="exampleInputEmail1"></label>
										</div>
									</li>
									<li>
										<p>배점</p>
										<div class="form-group">
											<input type="int" name="qPoint" class="form-contorl"
												placeholder="Enter qPoint">
										</div>
									</li>
								</ul>
							</td>
							<td>
								<p>문제입력</p>
								<div class="form-group">
									<textarea class="form-control" name="qInfo" rows="11"
										placeholder="Enter ..."></textarea>
								</div>
							</td>
							<td>
								EXAMPLES
								<ul class="w3-ul w3-border">
									<li>1)
										<div class="form-group">
											<input class="w3-input" name="ex1" rows="1"
												placeholder="Enter ...">
											</textarea>
										</div>
									</li>
									<li>2)
										<div class="form-group">
											<input class="w3-input" name="ex2" rows="1"
												placeholder="Enter ...">
											</textarea>
										</div>
									</li>
									<li>3)
										<div class="form-group">
											<input class="w3-input" name="ex3" rows="1"
												placeholder="Enter ...">
											</textarea>
										</div>
									</li>
									<li>4)
										<div class="form-group">
											<input class="w3-input" name="ex4" rows="1"
												placeholder="Enter ...">
											</textarea>
										</div>
									</li>
								</ul></td>
							<td>
								<div>
									<p>
										정답 
										<label class="w3-validate">1)</label>
										<input class="w3-radio" type="radio" name="ex" value="1"> 
										<label class="w3-validate">2)</label>
										<input class="w3-radio" type="radio" name="ex" value="1">
										<label class="w3-validate">3)</label>
										<input class="w3-radio" type="radio" name="ex" value="1">
										<label class="w3-validate">4)</label>
										<input class="w3-radio" type="radio" name="ex" value="1">
									</p>
								</div>
							</td>
						</tr>
					</table>
				</c:forEach> --%>

			<div class="box-footer">
				<input type="submit" value="등록">
				<input type="reset" value="취소" onClick="self.location='/exam/managementExam?subjectCode='${subjectCode}';">
			</div>
		</form>
	</div>
<%@include file="../include/tFooter.jsp"%>