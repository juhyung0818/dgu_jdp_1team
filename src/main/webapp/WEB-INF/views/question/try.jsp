<%@include file="../include/sHeader.jsp"%>

<section class="content">
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

					<table class="w3-striped">
						<tr>
							<td colspan="3">QUESTION INFOMATION</td>
						</tr>

						<c:forEach items="${list}" var="questionVO">
							<tr>
								<td>Q${questionVO.qNumber}</td>
								<td>point: ${questionVO.qPoint}</td>
								<td>
									<label class="w3-validate">1)</label>
									<input class="w3-radio" type="radio" name="answer" value="1">
									<label class="w3-validate">2)</label>
									<input class="w3-radio" type="radio" name="answer" value="2">
									<label class="w3-validate">3)</label>
									<input class="w3-radio" type="radio" name="answer" value="3">
									<label class="w3-validate">4)</label>
									<input class="w3-radio" type="radio" name="answer" value="4">
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
				<!-- /.box-body -->
				<br><br>
			<form class="form-inline" role="form" method="post">	
				<div class="box-footer"><br>
					<input type="hidden" name="answer">
					<button type="submit" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge"> COMPLETE </button>
					<button type="reset" class="w3-btn w3-white w3-border w3-border-pink w3-round-xlarge"> CANCLE </button>
				</div>
			</form>
				</div>	
			</div>
		</div>
</section>

<%@include file="../include/sFooter.jsp"%>